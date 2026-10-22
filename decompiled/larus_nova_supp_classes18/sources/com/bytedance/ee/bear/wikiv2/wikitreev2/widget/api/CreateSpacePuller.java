package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api;

import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.SpaceInfo;
import com.bytedance.ee.util.io.NonProguard;
import io.reactivex.Flowable;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CreateSpacePuller extends b<Params, Result> {

    public static class Params implements NonProguard {
        public String cover_token;
        public String i18n_id;
        public String introduction;
        public String name;
        public List<String> space_class_id;
        public int space_type;
        public String uniq_id;
        public int wiki_scope;

        public Params() {
        }

        public static Params myLibParams() {
            Params r0 = new Params();
            r0.name = "myLib";
            r0.uniq_id = com.larksuite.framework.utils.l0.a().toString();
            r0.space_type = 2;
            return r0;
        }
    }

    public static class Result implements NonProguard {
        public static final int CREATE_FAIL = 3;
        public static final int CREATE_OK = 2;
        public static final int CREATING = 1;
        public boolean async;
        public SpaceInfo space;
        public String task_id;
        public int task_status;

        public Result() {
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder("Result{async=");
            r0.append(this.async);
            r0.append(", task_id='");
            r0.append(this.task_id);
            r0.append("', task_status=");
            r0.append(this.task_status);
            r0.append(", space=");
            SpaceInfo r1 = this.space;
            if (r1 == null) goto L5;
            String r2 = r1.space_id;
        L6:
            r0.append(r2);
            r0.append('}');
            return r0.toString();
        L5:
            r2 = "";
            goto L6
        }
    }

    public class a {
        public final CreateSpacePuller a;

        public a(NetService r2) {
            this.a = new CreateSpacePuller(r2);
        }

        public final Flowable<SpaceInfo> a(final Params r9, final long r10, final int r12) {
            if ((System.currentTimeMillis() - r10) > 30000) goto L5;
            if (r12 != 0) goto L8;
            int r0 = 0;
        L9:
            tt5.a.h("CreateSpacePuller", "createSpace times: " + r12 + ", delay: " + r0);
            return Flowable.just(Boolean.TRUE).delay(r0, TimeUnit.MILLISECONDS).flatMap(new c(this, r9)).flatMap(new d(this, r9, r10, r12));
        L8:
            r0 = (r12 * 500) + CCMLynxCardView.ViewType.BANNER;
            goto L9
        L5:
            return Flowable.error(new NetService.ServerErrorException(-5, "createSpace timeout", "", ""));
        }
    }

    public CreateSpacePuller(NetService r4) {
        super(r4, "/space/api/wiki/v2/space/create/", 1, 2);
    }
}
