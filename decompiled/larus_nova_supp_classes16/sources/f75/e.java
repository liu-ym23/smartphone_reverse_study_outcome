package f75;

import androidx.lifecycle.MutableLiveData;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionPayLoadData;
import com.bytedance.ee.bear.drive.biz.versions.model.VersionUploadModel;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements bu5.a {
    public final /* synthetic */ f75.a a;

    public static final class a<T, R> implements Function {
        public final /* synthetic */ String a;

        public a(String r1) {
            this.a = r1;
        }

        public final Object apply(Object r3) {
            Intrinsics.checkNotNullParameter((String) r3, "it");
            VersionUploadModel r4 = (VersionUploadModel) JSON.parseObject(this.a, new d(), new Feature[0]);
            VersionPayLoadData r0 = new VersionPayLoadData();
            r0.setToken(r4.getData().getToken());
            r0.setVersion(r4.getData().getVersion());
            r0.setSource(r4.getData().getSource());
            r0.setEditUserId(r4.getData().getEdit_user_id());
            r0.setOperation(VersionPayLoadData.OPERATION_UPDATE);
            return r0;
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ f75.a a;

        public b(f75.a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            MutableLiveData<VersionPayLoadData> r0 = this.a.e;
            r0.postValue((VersionPayLoadData) r2);
        }
    }

    public static final class c<T> implements Consumer {
        public static final c<T> a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            tt5.a.f("DriveComponent", (Throwable) r3, false);
        }
    }

    public e(f75.a r1) {
        this.a = r1;
    }

    public final void didReceivePush(String r3) {
        tt5.a.h("DriveComponent", "DRIVE_UPLOAD_FILE_VERSION: " + du5.b.f(r3));
        this.a.d.add(Flowable.just("").observeOn(fo5.d.a()).map(new a(r3)).observeOn(fo5.d.d()).subscribe(new b(this.a), c.a));
    }
}
