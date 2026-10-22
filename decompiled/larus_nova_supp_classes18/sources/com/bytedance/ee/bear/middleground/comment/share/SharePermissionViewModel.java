package com.bytedance.ee.bear.middleground.comment.share;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.contract.h0;
import com.bytedance.ee.bear.drive.biz.comment.e1;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.middleground.permission.collaborator.invite.InviteResult;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BaseEntity;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UserPermissionEntity;
import com.bytedance.ee.bear.middleground_permission_export.model.doc.IDocUserPermission;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import jg5.j;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import un5.l;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SharePermissionViewModel extends gn4.a {
    public static final /* synthetic */ int j = 0;
    public final p c;
    public final String d;
    public IDocUserPermission e;
    public final Map<String, IDocUserPermission> f;
    public final MutableLiveData<PreviewPermissionState> g;
    public boolean h;
    public final boolean i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel$PreviewPermissionState;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_INIT", "STATE_FALSE", "STATE_TRUE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreviewPermissionState extends Enum<PreviewPermissionState> {
        public static final PreviewPermissionState STATE_FALSE = null;
        public static final PreviewPermissionState STATE_INIT = null;
        public static final PreviewPermissionState STATE_TRUE = null;
        public static final /* synthetic */ PreviewPermissionState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<PreviewPermissionState> getEntries() {
            return b;
        }

        static {
            PreviewPermissionState r0 = new PreviewPermissionState("STATE_INIT", 0);
            STATE_INIT = r0;
            PreviewPermissionState r1 = new PreviewPermissionState("STATE_FALSE", 1);
            STATE_FALSE = r1;
            PreviewPermissionState r3 = new PreviewPermissionState("STATE_TRUE", 2);
            STATE_TRUE = r3;
            PreviewPermissionState[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static PreviewPermissionState[] values() {
            return (PreviewPermissionState[]) a.clone();
        }

        public static PreviewPermissionState valueOf(String r1) {
            return (PreviewPermissionState) r27.a.a(PreviewPermissionState.class, r1);
        }

        public PreviewPermissionState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static final class a {
    }

    public static final class b {
        public final boolean a;
        public final boolean b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (this.a == r6.a) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r1 = 1231;
            if (this.a == false) goto L5;
            int r0 = 1231;
        L6:
            int r2 = r0 * 31;
            if (this.b == true) goto L11;
            r1 = 1237;
        L11:
            return r2 + r1;
        L5:
            r0 = 1237;
            goto L6
        }

        public final String toString() {
            return "UserPermissionResult(canRead=" + this.a + ", canShare=" + this.b + ')';
        }

        public b(boolean r1, boolean r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ SharePermissionViewModel a;
        public final /* synthetic */ Ref.ObjectRef<l[]> b;
        public final /* synthetic */ TextView c;
        public final /* synthetic */ Function1<l, Unit> d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(SharePermissionViewModel r1, Ref.ObjectRef<l[]> r2, TextView r3, Function1<? super l, Unit> r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final void accept(Object r10) {
            HashMap r11 = (HashMap) r10;
            Map<String, IDocUserPermission> r0 = this.a.f;
            Intrinsics.checkNotNull(r11);
            r0.putAll(r11);
            Ref.ObjectRef<l[]> r1 = this.b;
            CharSequence r2 = this.c.getText();
            Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.text.Spanned");
            r1.element = ((Spanned) r2).getSpans(0, this.c.getText().length(), l.class);
            l[] r3 = (l[]) this.b.element;
            int r4 = r3.length;
            int r5 = 0;
        L3:
            if (r5 >= r4) goto L59;
            l r6 = r3[r5];
            if (r11.containsKey(r6.d) == false) goto L58;
            IDocUserPermission r7 = (IDocUserPermission) ((LinkedHashMap) this.a.f).get(r6.d);
            boolean r8 = true;
            if (r7 != null) goto L9;
        L11:
            boolean r9 = false;
        L12:
            if (r9 == true) goto L29;
            IDocUserPermission r12 = (IDocUserPermission) ((LinkedHashMap) this.a.f).get(r6.d);
            if (r12 != null) goto L16;
        L18:
            boolean r13 = false;
        L19:
            if (r13 == false) goto L28;
            IDocUserPermission r14 = (IDocUserPermission) ((LinkedHashMap) this.a.f).get(r6.d);
            if (r14 != null) goto L23;
        L25:
            boolean r15 = false;
        L26:
            if (r15 == false) goto L28;
        L23:
            if (r14.canPerceive() != true) goto L25;
            r15 = true;
        L28:
            boolean r16 = false;
        L30:
            SharePermissionViewModel r17 = this.a;
            if (r17.i == false) goto L41;
            r6.j = !r16;
            IDocUserPermission r18 = r17.e;
            if (r18 != null) goto L35;
        L37:
            r8 = false;
        L38:
            r6.k = r8;
            Function1<l, Unit> r19 = this.d;
            if (r19 == null) goto L58;
            Intrinsics.checkNotNull(r6);
            r19.invoke(r6);
            goto L58
        L35:
            if (r18.canManageCollaborator() != true) goto L37;
        L41:
            if (r16 == true) goto L50;
            IDocUserPermission r20 = r17.e;
            if (r20 != null) goto L45;
        L47:
            boolean r21 = false;
        L48:
            if (r21 == false) goto L50;
            boolean r22 = true;
        L51:
            r6.j = r22;
            IDocUserPermission r23 = this.a.e;
            if (r23 != null) goto L54;
        L56:
            r8 = false;
        L57:
            r6.k = r8;
            goto L58
        L54:
            if (r23.canManageCollaborator() != true) goto L56;
        L45:
            if (r20.canManageCollaborator() != true) goto L47;
            r21 = true;
        L50:
            r22 = false;
            goto L51
        L16:
            if (r12.canRead() == true) goto L18;
            r13 = true;
        L29:
            r16 = true;
            goto L30
        L9:
            if (r7.canRead() != true) goto L11;
            r9 = true;
        L58:
            r5 = r5 + 1;
            goto L3
        L59:
            SharePermissionViewModel r110 = this.a;
            TextView r24 = this.c;
            r110.getClass();
            SharePermissionViewModel.o(r24);
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ SharePermissionViewModel a;

        public d(SharePermissionViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.e(this.a.d, "fetchUserPermission: ", r5, false);
        }
    }

    public static final class e implements com.bytedance.ee.bear.middleground_permission_export.model.e {
        public final /* synthetic */ SharePermissionViewModel a;
        public final /* synthetic */ String b;
        public final /* synthetic */ bf5.b c;

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
        public final void a(InviteResult r2) {
            Intrinsics.checkNotNullParameter(r2, "inviteResult");
            this.a.f.remove(this.b);
            this.c.d(this.b);
        }

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
        public final void onError(Throwable r4) {
            Intrinsics.checkNotNullParameter(r4, "throwable");
            tt5.a.e(this.a.d, "onRequestFail: ", r4, false);
            this.c.b(r4);
        }

        public e(SharePermissionViewModel r1, String r2, bf5.b r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ String a;
        public final /* synthetic */ SharePermissionViewModel b;

        public f(String r1, SharePermissionViewModel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r8) {
            IDocUserPermission r9 = (IDocUserPermission) r8;
            boolean r0 = r9.canPreview();
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.a.g() == false) goto L5;
            r0 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(this.a, sbb.e.l, BizDomain.FileBizDomainCCM, ""), "VIEW_PREVIEW"), new UserPermissionEntity(r9, null)).getAllow();
        L5:
            if (r0 == false) goto L7;
            this.b.g.setValue(PreviewPermissionState.STATE_TRUE);
        L8:
            tt5.a.h(this.b.d, "requestFilePreviewPermission: success " + r0);
            return;
        L7:
            this.b.g.setValue(PreviewPermissionState.STATE_FALSE);
            goto L8
        }
    }

    public static final class g<T> implements Consumer {
        public final /* synthetic */ SharePermissionViewModel a;

        public g(SharePermissionViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            tt5.a.h(this.a.d, "requestFilePreviewPermission: " + ((Throwable) r4).getMessage());
            if (this.a.g.getValue() != PreviewPermissionState.STATE_INIT) goto L5;
            tt5.a.h(this.a.d, "requestFilePreviewPermission: err notify");
            this.a.g.setValue(PreviewPermissionState.STATE_FALSE);
            return;
        L5:
            tt5.a.h(this.a.d, "requestFilePreviewPermission: only timeout not notify");
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ SharePermissionViewModel a;
        public final /* synthetic */ String b;

        public h(SharePermissionViewModel r1, String r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r3) {
            HashMap r4 = (HashMap) r3;
            SharePermissionViewModel r0 = this.a;
            r0.e = (IDocUserPermission) r4.get(this.b);
            Map<String, IDocUserPermission> r1 = this.a.f;
            Intrinsics.checkNotNull(r4);
            r1.putAll(r4);
        }
    }

    public static final class i<T> implements Consumer {
        public final /* synthetic */ SharePermissionViewModel a;

        public i(SharePermissionViewModel r1) {
            this.a = r1;
        }

        public final void accept(Object r4) {
            Throwable r5 = (Throwable) r4;
            Intrinsics.checkNotNullParameter(r5, "throwable");
            tt5.a.e(this.a.d, "fetchUserPermission: ", r5, false);
        }
    }

    static {
    }

    public final void d() {
        ((LinkedHashMap) this.f).clear();
    }

    public final boolean e() {
        IDocUserPermission r0 = this.e;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.canManageCollaborator() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final PreviewPermissionState h() {
        return (PreviewPermissionState) this.g.getValue();
    }

    public final void n() {
        String r0 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().uid;
        j r1 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r2 = this.c;
        String r3 = r2.i;
        int r4 = r2.k.b;
        ArrayList r5 = CollectionsKt.arrayListOf(new String[]{r0});
        r1.getClass();
        a(li5.c.a(r4, r3, r5).subscribe(new h(this, r0), new i(this)));
    }

    public SharePermissionViewModel(p r2) {
        Intrinsics.checkNotNullParameter(r2, "configComment");
        this.c = r2;
        this.d = "Comment#SharePermissionViewModel";
        this.f = new LinkedHashMap();
        this.g = new MutableLiveData(PreviewPermissionState.STATE_INIT);
        com.bytedance.ee.bear.appsetting.c r3 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r3.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r4 = false;
    L8:
        this.i = r4;
        n();
        return;
    L5:
        if (r3.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r4 = true;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void o(TextView r4) {
        r4.invalidate();
        if ((r4 instanceof CommentEditText) == false) goto L14;
        CommentEditText r5 = (CommentEditText) r4;
        if ((r5.getText() instanceof SpannableStringBuilder) == false) goto L15;
        Editable r6 = r5.getText();
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        SpannableStringBuilder r7 = (SpannableStringBuilder) r6;
        l[] r0 = (l[]) r7.getSpans(0, r7.length(), l.class);
        Intrinsics.checkNotNull(r0);
        if (r0.length != 0) goto L9;
        boolean r1 = true;
    L11:
        if ((!r1) == false) goto L16;
        l r2 = r0[0];
        int r3 = r7.getSpanStart(r2);
        int r8 = r7.getSpanEnd(r2);
        r7.removeSpan(r2);
        r2.getClass();
        r7.setSpan(r2, r3, r8, 33);
        return;
    L16:
        return;
    L9:
        r1 = false;
        goto L11
    L15:
        return;
    }

    public final void l(List<String> r3) {
        Intrinsics.checkNotNullParameter(r3, "userIds");
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        String r0 = (String) r4.next();
        this.f.remove(r0);
        goto L4
    }

    public final void f(String r6, Function2 r7) {
        Intrinsics.checkNotNullParameter(r6, "userId");
        Intrinsics.checkNotNullParameter(r7, "callback");
        if (this.f.containsKey(r6) == false) goto L5;
        ((LinkedHashMap) this.f).get(r6);
    L5:
        j r0 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r1 = this.c;
        String r2 = r1.i;
        int r3 = r1.k.b;
        ArrayList r4 = CollectionsKt.arrayListOf(new String[]{r6});
        r0.getClass();
        a(li5.c.a(r3, r2, r4).subscribe(new mf5.c(r6, this, r7), new mf5.d(this)));
    }

    public final void g(List r6, Function1 r7) {
        Intrinsics.checkNotNullParameter(r6, "userIds");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ArrayList r0 = new ArrayList();
        Iterator r8 = r6.iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        Object r1 = r8.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r9 = CollectionsKt.distinct(r0);
        if (r9.isEmpty() == false) goto L12;
        r7.invoke(MapsKt.emptyMap());
        return;
    L12:
        LinkedHashMap r2 = new LinkedHashMap();
        ArrayList r3 = new ArrayList();
        Iterator r10 = r9.iterator();
    L14:
        if (r10.hasNext() == false) goto L17;
        String r4 = (String) r10.next();
        IDocUserPermission r5 = (IDocUserPermission) ((LinkedHashMap) this.f).get(r4);
        r3.add(r4);
        goto L14
    L17:
        if (r3.isEmpty() == false) goto L20;
        r7.invoke(r2);
        return;
    L20:
        j r11 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r12 = this.c;
        String r13 = r12.i;
        int r14 = r12.k.b;
        ArrayList r15 = new ArrayList(r3);
        r11.getClass();
        Flowable<HashMap<String, IDocUserPermission>> r16 = li5.c.a(r14, r13, r15);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment.request_permission_if_no_cache") == false) goto L23;
        r16 = r16.retry(1);
    L23:
        a(r16.subscribe(new com.bytedance.ee.bear.middleground.comment.share.a(this, r3, r7, r2), new com.bytedance.ee.bear.middleground.comment.share.b(this, r7, r2)));
    }

    public final void j(List r10, e1 r11) {
        Intrinsics.checkNotNullParameter(r10, "userIds");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (this.c.l == false) goto L5;
        int r2 = 2;
    L6:
        List r0 = r10;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator r1 = r0.iterator();
    L8:
        if (r1.hasNext() == false) goto L10;
        String r3 = (String) r1.next();
        UserInfo r4 = new UserInfo();
        r4.setId(r3);
        r4.setOwnerType(1);
        r6.add(r4);
        goto L8
    L10:
        p r5 = this.c;
        int r7 = r2;
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.g r8 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.g(r7, r5.j, r5.k.b, r5.i, true);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().g(r8, r6, new mf5.e(r11, this, r10));
        return;
    L5:
        r2 = 1;
        goto L6
    }

    public final void m(p r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "config");
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        tt5.a.h(this.d, "requestFilePreviewPermission: start");
        if (this.h == false) goto L5;
        return;
    L5:
        this.h = true;
        tt5.a.h(this.d, "requestFilePreviewPermission: in");
        j r1 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        int r5 = sbb.e.l.b;
        String r6 = r10.i;
        int r7 = r10.k.b;
        r1.getClass();
        wh5.d r8 = new wh5.d();
        Intrinsics.checkNotNullParameter(r11, ResourceData.KEY_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "parentToken");
        a(Flowable.create(new wh5.f(r11, r5, r6, r7, r8), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).timeout(20000, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new f(r11, this), new g(this)));
    }

    public final void i(TextView r12, boolean r13, Function1<? super l, Unit> r14) {
        Intrinsics.checkNotNullParameter(r12, "textView");
        if (this.c.B == true) goto L5;
        return;
    L5:
        boolean r1 = false;
        if (r12.getText().length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        Ref.ObjectRef r2 = new Ref.ObjectRef();
        CharSequence r3 = r12.getText();
        if ((r3 instanceof Spanned) == false) goto L14;
        Spanned r4 = (Spanned) r3;
    L15:
        if (r4 != null) goto L17;
        return;
    L17:
        l[] r5 = (l[]) r4.getSpans(0, r12.getText().length(), l.class);
        if (r5 != null) goto L20;
        return;
    L20:
        r2.element = r5;
        ArrayList r6 = new ArrayList();
        l[] r7 = (l[]) r2.element;
        int r8 = r7.length;
        int r9 = 0;
    L21:
        if (r9 >= r8) goto L70;
        l r10 = r7[r9];
        if (this.f.containsKey(r10.d) == false) goto L66;
        IDocUserPermission r11 = (IDocUserPermission) ((LinkedHashMap) this.f).get(r10.d);
        if (r11 != null) goto L27;
    L63:
        if (r13 == true) goto L68;
        r6.add(r10.d);
    L68:
        r9 = r9 + 1;
        goto L21
    L27:
        if (this.i == false) goto L44;
        if (r11.canRead() == false) goto L31;
    L33:
        boolean r15 = false;
    L34:
        r10.j = r15;
        IDocUserPermission r16 = this.e;
        if (r16 != null) goto L37;
    L39:
        boolean r17 = false;
    L40:
        r10.k = r17;
        if (r14 == null) goto L63;
        Intrinsics.checkNotNull(r10);
        r14.invoke(r10);
        goto L63
    L37:
        if (r16.canManageCollaborator() != true) goto L39;
        r17 = true;
        goto L40
    L31:
        if (r11.canPerceive() == true) goto L33;
        r15 = true;
        goto L34
    L44:
        if (r11.canRead() == false) goto L46;
    L55:
        boolean r18 = false;
    L56:
        r10.j = r18;
        IDocUserPermission r19 = this.e;
        if (r19 != null) goto L59;
    L61:
        boolean r20 = false;
    L62:
        r10.k = r20;
        goto L63
    L59:
        if (r19.canManageCollaborator() != true) goto L61;
        r20 = true;
        goto L62
    L46:
        if (r11.canPerceive() == true) goto L55;
        IDocUserPermission r21 = this.e;
        if (r21 != null) goto L50;
    L52:
        boolean r22 = false;
    L53:
        if (r22 == false) goto L55;
        r18 = true;
        goto L56
    L50:
        if (r21.canManageCollaborator() != true) goto L52;
        r22 = true;
        goto L53
    L66:
        if (r6.contains(r10.d) == true) goto L68;
        r6.add(r10.d);
        goto L68
    L70:
        if (r6.size() != 0) goto L78;
        if (((Object[]) r2.element).length != 0) goto L75;
        r1 = true;
    L75:
        if ((!r1) == false) goto L78;
        o(r12);
    L78:
        if (r6.size() == 0) goto L83;
        ArrayList r110 = new ArrayList();
        r110.addAll(CollectionsKt.take(r6, 10));
        r6.removeAll(r110);
        j r23 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r24 = this.c;
        String r25 = r24.i;
        int r26 = r24.k.b;
        r23.getClass();
        Flowable<HashMap<String, IDocUserPermission>> r111 = li5.c.a(r26, r25, r110);
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment.request_permission_if_no_cache") == false) goto L82;
        r111 = r111.retry(1);
    L82:
        a(r111.subscribe(new c(this, r2, r12, r14), new d(this)));
        goto L78
    L83:
        return;
    L14:
        r4 = null;
        goto L15
    L8:
        r0 = false;
        goto L9
    }

    public final void k(String r9, boolean r10, bf5.b r11) {
        Intrinsics.checkNotNullParameter(r9, "userId");
        Intrinsics.checkNotNullParameter(r11, "callback");
        if (this.c.l == false) goto L5;
        int r3 = 2;
    L6:
        UserInfo r2 = new UserInfo();
        r2.setId(r9);
        r2.setOwnerType(1);
        Unit r1 = Unit.INSTANCE;
        ArrayList r0 = CollectionsKt.arrayListOf(new UserInfo[]{r2});
        p r4 = this.c;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().g(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.g(r3, r4.j, r4.k.b, r4.i, r10), r0, new e(this, r9, r11));
        return;
    L5:
        r3 = 1;
        goto L6
    }
}
