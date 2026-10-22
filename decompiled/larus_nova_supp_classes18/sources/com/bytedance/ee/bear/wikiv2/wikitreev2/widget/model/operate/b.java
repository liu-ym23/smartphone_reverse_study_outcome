package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate;

import com.bytedance.ee.bear.quoto.t;
import com.bytedance.ee.bear.wikiv2.wikitreev2.notification.WikiTreeNotificationServiceImpl;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.CreateNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.DelNodePuller;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.h;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.TreeNode;
import com.bytedance.ee.util.info.AppInfoUtils;
import io.reactivex.Flowable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements IOperationInsert, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a {

    public static final class a {
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.b$b, reason: collision with other inner class name */
    public static final class C0219b<T, R> implements Function {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a a;
        public final /* synthetic */ ce5.a b;

        public C0219b(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r4) {
            Intrinsics.checkNotNullParameter((String) r4, "it");
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r0 = this.a;
            DelNodePuller.Params r5 = new DelNodePuller.Params(r0.a, r0.b, r0.chainPushUUid);
            return new DelNodePuller(this.b.c).d(r5);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a a;

        public c(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            DelNodePuller.Result r3 = (DelNodePuller.Result) r2;
            Lazy<WikiTreeNotificationServiceImpl> r4 = WikiTreeNotificationServiceImpl.b;
            WikiTreeNotificationServiceImpl.a.a().b(this.a);
            jw4.a.g("delete", this.a.e);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a a;

        public d(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.d("WikiNodeOperationImpl", "IOperationDelete, delete fail. " + du5.b.f(r5));
            int r0 = rq5.a.a;
            com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r1 = this.a;
            rq5.a.C0302a.a(r5, r1.a, r1.b, true);
            this.a.d = r5;
            Lazy<WikiTreeNotificationServiceImpl> r2 = WikiTreeNotificationServiceImpl.b;
            WikiTreeNotificationServiceImpl.a.a().a(this.a);
            jw4.a.h("delete", r5, this.a.e);
        }
    }

    public static final class e<T, R> implements Function {
        public final /* synthetic */ IOperationInsert.TreeNodeInsertParams a;
        public final /* synthetic */ ce5.a b;

        public e(IOperationInsert.TreeNodeInsertParams r1, ce5.a r2) {
            this.a = r1;
            this.b = r2;
        }

        public final Object apply(Object r12) {
            Intrinsics.checkNotNullParameter((String) r12, "it");
            IOperationInsert.TreeNodeInsertParams r13 = this.a;
            String r6 = r13.parentOriginSpaceId;
            String r7 = r13.parentOriginToken;
            String r8 = r13.title;
            int r9 = r13.documentType;
            CreateNodePuller.Params r10 = new CreateNodePuller.Params(r6, r7, r8, r9, r13.chainPushUUid);
            IOperationInsert.TreeNodeInsertParams r14 = this.a;
            String r0 = r14.templateToken;
            boolean r1 = false;
            if (r0 != null) goto L5;
        L8:
            boolean r2 = true;
        L9:
            if (r2 == true) goto L11;
            r10.template_token = r14.templateToken;
        L11:
            String r3 = r14.extInfo;
            if (r3 != null) goto L14;
        L15:
            r1 = true;
        L16:
            if (r1 == true) goto L18;
            r10.ext_info_str = r14.extInfo;
        L18:
            Flowable r15 = new CreateNodePuller(this.b.c).d(r10);
            if (this.a.offlineCreateEnable == false) goto L28;
            boolean r4 = !AppInfoUtils.f().booleanValue();
            if (com.bytedance.ee.bear.list.create.a.a(r9) == false) goto L26;
            if (r4 == true) goto L25;
            return r15;
        L25:
            return h.a(r6, r7, r8, r9, this.b);
        L26:
            return r15;
        L28:
            return r15;
        L14:
            if (StringsKt.isBlank(r3) == false) goto L16;
        L5:
            if (StringsKt.isBlank(r0) == true) goto L8;
            r2 = false;
            goto L9
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ IOperationInsert.TreeNodeInsertParams a;

        public f(IOperationInsert.TreeNodeInsertParams r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            TreeNode r4 = (TreeNode) r3;
            Intrinsics.checkNotNull(r4);
            IOperationInsert.TreeNodeInsertResult r0 = new IOperationInsert.TreeNodeInsertResult(r4);
            IOperationInsert.TreeNodeInsertParams r5 = this.a;
            r0.parentToken = r5.parentToken;
            r0.parentSpaceId = r5.parentSpaceId;
            r0.parentOriginSpaceId = r5.parentOriginSpaceId;
            String r1 = r5.parentOriginToken;
            if (r1 == null) goto L5;
            r0.parentOriginToken = r1;
        L5:
            r0.uid = r5.uid;
            r0.forceExpand = r5.forceExpand;
            r0.chainPushUUid = r5.chainPushUUid;
            Lazy<WikiTreeNotificationServiceImpl> r6 = WikiTreeNotificationServiceImpl.b;
            WikiTreeNotificationServiceImpl.a.a().d(r0);
            jw4.a.g("create", Integer.valueOf(this.a.documentType));
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ IOperationInsert.TreeNodeInsertParams a;

        public g(IOperationInsert.TreeNodeInsertParams r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            tt5.a.d("WikiNodeOperationImpl", "IOperationInsert, insert fail. " + r5);
            ((t) org.koin.java.a.c(t.class, null, null, 6)).a(r5, null);
            ((t) org.koin.java.a.c(t.class, null, null, 6)).p(r5, null, false);
            jw4.a.h("create", r5, Integer.valueOf(this.a.documentType));
        }
    }

    static {
    }

    public b() {
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a
    public void delete(ce5.a r3, com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.a.C0218a r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r3, "userAbility");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "disposables");
        r5.add(Flowable.just("").flatMap(new C0219b(r4, r3)).observeOn(fo5.d.e()).subscribe(new c(r4), new d(r4)));
    }

    @Override // com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.operate.IOperationInsert
    public void insert(ce5.a r3, IOperationInsert.TreeNodeInsertParams r4, CompositeDisposable r5) {
        Intrinsics.checkNotNullParameter(r3, "userAbility");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "disposables");
        r5.add(Flowable.just("").flatMap(new e(r4, r3)).observeOn(fo5.d.d()).subscribe(new f(r4), new g(r4)));
    }
}
