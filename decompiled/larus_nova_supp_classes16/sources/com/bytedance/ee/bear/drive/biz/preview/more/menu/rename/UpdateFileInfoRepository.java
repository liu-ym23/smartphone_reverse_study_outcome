package com.bytedance.ee.bear.drive.biz.preview.more.menu.rename;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class UpdateFileInfoRepository {
    public final NetService.d<Result> a;

    public static class Params implements Serializable {
        public String file_token;
        public String mount_node_token;
        public String mount_point;
        public String name;

        public Params() {
        }

        public String toString() {
            return "Params{file_token='" + du5.b.g(this.file_token) + "', name='" + this.name + "', mount_node_token='" + this.mount_node_token + "', mount_point='" + this.mount_point + "'}";
        }
    }

    public class a implements Consumer<Result> {
        public final /* synthetic */ d a;

        public a(d r1) {
            this.a = r1;
        }

        public final void accept(Object r4) throws Exception {
            int r5 = ((Result) r4).getCode();
            if (r5 == 0) goto L5;
            ((RenameItemV2.a) this.a).a(r5);
            return;
        L5:
            RenameItemV2.a r6 = (RenameItemV2.a) this.a;
            if (RenameItemV2.access$000(r6.c) != null) goto L8;
            tt5.a.d("DRIVE_RenameItemV2", "onSuccess context is null");
            return;
        L8:
            Toast.showSuccessText(RenameItemV2.access$000(r6.c), RenameItemV2.access$000(r6.c).getString(2131888444), 0);
            RenameItemV2.access$100(r6.c, r6.a, r6.b);
            t r0 = RenameItemV2.access$300(r6.c);
            String r1 = du5.d.a(((f85.a.C0229a) RenameItemV2.access$200(r6.c).a).a);
            String r7 = r6.a;
            r0.getClass();
            t.q(r1, r7);
        }
    }

    public class b implements Consumer<Throwable> {
        public final /* synthetic */ Params a;
        public final /* synthetic */ d b;

        public final void accept(Object r4) throws Exception {
            Throwable r5 = (Throwable) r4;
            tt5.a.d("DRIVE_UpdateFileInfoRepository", String.format("UpdateFileInfoRepository.update() error, msg: %s, params: ", new Object[]{r5, this.a.toString()}));
            if ((r5 instanceof NetService.ServerErrorException) == false) goto L5;
            int r6 = ((NetService.ServerErrorException) r5).getCode();
        L6:
            ((RenameItemV2.a) this.b).a(r6);
            return;
        L5:
            r6 = -1;
            goto L6
        }

        public b(Params r1, d r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static class c implements NetService.c<Result> {

        public class a extends TypeReference<Result> {
            public a() {
            }
        }

        public c() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result parse(String r3) throws NetService.ParseException {
            return (Result) JSON.parseObject(r3, new a(), new Feature[0]);
        }
    }

    public interface d {
    }

    public UpdateFileInfoRepository(NetService r2) {
        this.a = r2.Vc(new c());
    }

    public Disposable update(String r2, String r3, String r4, d r5) {
        Params r0 = new Params();
        r0.file_token = r2;
        r0.name = r3;
        NetService.f r6 = new NetService.f("/api/box/file/update_info/");
        r6.j = JSON.toJSONString(r0);
        if (TextUtils.isEmpty(r4) == true) goto L5;
        r6.b(DrivePreviewOpenItem.EXTRA_MOUNT_POINT, r4);
    L5:
        r6.c = 1;
        return this.a.a(r6).subscribe(new a(r5), new b(r0, r5));
    }
}
