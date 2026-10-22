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
import com.lynx.tasm.LynxError;
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

/* JADX INFO: loaded from: classes18.dex */
public final class SharePermissionViewModel extends gn4.a {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f232152j = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f232153c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f232154d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IDocUserPermission f232155e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, IDocUserPermission> f232156f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final MutableLiveData<PreviewPermissionState> f232157g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f232158h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f232159i;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/share/SharePermissionViewModel$PreviewPermissionState;", "", "<init>", "(Ljava/lang/String;I)V", "STATE_INIT", "STATE_FALSE", "STATE_TRUE", "middleground-comment_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum PreviewPermissionState extends Enum<PreviewPermissionState> {
        public static final PreviewPermissionState STATE_FALSE = null;
        public static final PreviewPermissionState STATE_INIT = null;
        public static final PreviewPermissionState STATE_TRUE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ PreviewPermissionState[] f232160a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f232161b = null;

        public static EnumEntries<PreviewPermissionState> getEntries() {
            return f232161b;
        }

        static {
            PreviewPermissionState r100 = new PreviewPermissionState("STATE_INIT", 0);
            STATE_INIT = r100;
            PreviewPermissionState r101 = new PreviewPermissionState("STATE_FALSE", 1);
            STATE_FALSE = r101;
            PreviewPermissionState r102 = new PreviewPermissionState("STATE_TRUE", 2);
            STATE_TRUE = r102;
            PreviewPermissionState[] r103 = {r100, r101, r102};
            f232160a = r103;
            f232161b = EnumEntriesKt.enumEntries(r103);
        }

        public static PreviewPermissionState[] values() {
            return (PreviewPermissionState[]) f232160a.clone();
        }

        public static PreviewPermissionState valueOf(String r100) {
            return (PreviewPermissionState) r27.a.a(PreviewPermissionState.class, r100);
        }

        public PreviewPermissionState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f232162a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f232163b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f232162a == r101.f232162a) goto L12;
            return false;
        L12:
            if (this.f232163b == r101.f232163b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f232162a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f232163b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "UserPermissionResult(canRead=" + this.f232162a + ", canShare=" + this.f232163b + ')';
        }

        public b(boolean r100, boolean r101) {
            this.f232162a = r100;
            this.f232163b = r101;
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232164a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<l[]> f232165b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ TextView f232166c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<l, Unit> f232167d;

        /* JADX WARN: Multi-variable type inference failed */
        public c(SharePermissionViewModel r100, Ref.ObjectRef<l[]> r101, TextView r102, Function1<? super l, Unit> r103) {
            this.f232164a = r100;
            this.f232165b = r101;
            this.f232166c = r102;
            this.f232167d = r103;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r110) {
            HashMap r111 = (HashMap) r110;
            Map<String, IDocUserPermission> r100 = this.f232164a.f232156f;
            Intrinsics.checkNotNull(r111);
            r100.putAll(r111);
            Ref.ObjectRef<l[]> r101 = this.f232165b;
            CharSequence r102 = this.f232166c.getText();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.text.Spanned");
            r101.element = (T) ((Spanned) r102).getSpans(0, this.f232166c.getText().length(), l.class);
            l[] r103 = this.f232165b.element;
            int r104 = r103.length;
            int r105 = 0;
        L3:
            if (r105 >= r104) goto L59;
            l r106 = r103[r105];
            if (r111.containsKey(r106.f550815d) == false) goto L58;
            IDocUserPermission r107 = (IDocUserPermission) ((LinkedHashMap) this.f232164a.f232156f).get(r106.f550815d);
            boolean r108 = true;
            if (r107 != null) goto L9;
        L11:
            boolean r109 = false;
        L12:
            if (r109 == true) goto L29;
            IDocUserPermission r112 = (IDocUserPermission) ((LinkedHashMap) this.f232164a.f232156f).get(r106.f550815d);
            if (r112 != null) goto L16;
        L18:
            boolean r113 = false;
        L19:
            if (r113 == false) goto L28;
            IDocUserPermission r114 = (IDocUserPermission) ((LinkedHashMap) this.f232164a.f232156f).get(r106.f550815d);
            if (r114 != null) goto L23;
        L25:
            boolean r115 = false;
        L26:
            if (r115 == false) goto L28;
        L23:
            if (r114.canPerceive() != true) goto L25;
            r115 = true;
        L28:
            boolean r116 = false;
        L30:
            SharePermissionViewModel r117 = this.f232164a;
            if (r117.f232159i == false) goto L41;
            r106.f550821j = !r116;
            IDocUserPermission r118 = r117.f232155e;
            if (r118 != null) goto L35;
        L37:
            r108 = false;
        L38:
            r106.f550822k = r108;
            Function1<l, Unit> r119 = this.f232167d;
            if (r119 == null) goto L58;
            Intrinsics.checkNotNull(r106);
            r119.invoke(r106);
            goto L58
        L35:
            if (r118.canManageCollaborator() != true) goto L37;
        L41:
            if (r116 == true) goto L50;
            IDocUserPermission r120 = r117.f232155e;
            if (r120 != null) goto L45;
        L47:
            boolean r121 = false;
        L48:
            if (r121 == false) goto L50;
            boolean r122 = true;
        L51:
            r106.f550821j = r122;
            IDocUserPermission r123 = this.f232164a.f232155e;
            if (r123 != null) goto L54;
        L56:
            r108 = false;
        L57:
            r106.f550822k = r108;
            goto L58
        L54:
            if (r123.canManageCollaborator() != true) goto L56;
        L45:
            if (r120.canManageCollaborator() != true) goto L47;
            r121 = true;
        L50:
            r122 = false;
            goto L51
        L16:
            if (r112.canRead() == true) goto L18;
            r113 = true;
        L29:
            r116 = true;
            goto L30
        L9:
            if (r107.canRead() != true) goto L11;
            r109 = true;
        L58:
            r105 = r105 + 1;
            goto L3
        L59:
            SharePermissionViewModel r124 = this.f232164a;
            TextView r125 = this.f232166c;
            r124.getClass();
            SharePermissionViewModel.o(r125);
        }
    }

    public static final class d<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232168a;

        public d(SharePermissionViewModel r100) {
            this.f232168a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.e(this.f232168a.f232154d, "fetchUserPermission: ", r101, false);
        }
    }

    public static final class e implements com.bytedance.ee.bear.middleground_permission_export.model.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232169a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f232170b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ bf5.b f232171c;

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
        public final void a(InviteResult r100) {
            Intrinsics.checkNotNullParameter(r100, "inviteResult");
            this.f232169a.f232156f.remove(this.f232170b);
            this.f232171c.d(this.f232170b);
        }

        @Override // com.bytedance.ee.bear.middleground_permission_export.model.e
        public final void onError(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, LynxError.LYNX_THROWABLE);
            tt5.a.e(this.f232169a.f232154d, "onRequestFail: ", r100, false);
            this.f232171c.b(r100);
        }

        public e(SharePermissionViewModel r100, String r101, bf5.b r102) {
            this.f232169a = r100;
            this.f232170b = r101;
            this.f232171c = r102;
        }
    }

    public static final class f<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f232172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232173b;

        public f(String r100, SharePermissionViewModel r101) {
            this.f232172a = r100;
            this.f232173b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            IDocUserPermission r101 = (IDocUserPermission) r100;
            boolean r102 = r101.canPreview();
            ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
            if (jg5.e.a.f499003a.g() == false) goto L5;
            r102 = ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(new BaseEntity(this.f232172a, sbb.e.f541301l, BizDomain.FileBizDomainCCM, ""), "VIEW_PREVIEW"), new UserPermissionEntity(r101, null)).getAllow();
        L5:
            if (r102 == false) goto L7;
            this.f232173b.f232157g.setValue(PreviewPermissionState.STATE_TRUE);
        L8:
            tt5.a.h(this.f232173b.f232154d, "requestFilePreviewPermission: success " + r102);
            return;
        L7:
            this.f232173b.f232157g.setValue(PreviewPermissionState.STATE_FALSE);
            goto L8
        }
    }

    public static final class g<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232174a;

        public g(SharePermissionViewModel r100) {
            this.f232174a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            tt5.a.h(this.f232174a.f232154d, "requestFilePreviewPermission: " + ((Throwable) r100).getMessage());
            if (this.f232174a.f232157g.getValue() != PreviewPermissionState.STATE_INIT) goto L5;
            tt5.a.h(this.f232174a.f232154d, "requestFilePreviewPermission: err notify");
            this.f232174a.f232157g.setValue(PreviewPermissionState.STATE_FALSE);
            return;
        L5:
            tt5.a.h(this.f232174a.f232154d, "requestFilePreviewPermission: only timeout not notify");
        }
    }

    public static final class h<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232175a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f232176b;

        public h(SharePermissionViewModel r100, String r101) {
            this.f232175a = r100;
            this.f232176b = r101;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            HashMap r101 = (HashMap) r100;
            SharePermissionViewModel r102 = this.f232175a;
            r102.f232155e = (IDocUserPermission) r101.get(this.f232176b);
            Map<String, IDocUserPermission> r103 = this.f232175a.f232156f;
            Intrinsics.checkNotNull(r101);
            r103.putAll(r101);
        }
    }

    public static final class i<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SharePermissionViewModel f232177a;

        public i(SharePermissionViewModel r100) {
            this.f232177a = r100;
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Throwable r101 = (Throwable) r100;
            Intrinsics.checkNotNullParameter(r101, LynxError.LYNX_THROWABLE);
            tt5.a.e(this.f232177a.f232154d, "fetchUserPermission: ", r101, false);
        }
    }

    static {
    }

    public final void d() {
        ((LinkedHashMap) this.f232156f).clear();
    }

    public final boolean e() {
        IDocUserPermission r100 = this.f232155e;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.canManageCollaborator() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public final PreviewPermissionState h() {
        return this.f232157g.getValue();
    }

    public final void n() {
        String r100 = ((h0) org.koin.java.a.c(h0.class, null, null, 6)).G2().uid;
        j r101 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r102 = this.f232153c;
        String r103 = r102.f232233i;
        int r104 = r102.f232235k.f541317b;
        ArrayList r105 = CollectionsKt.arrayListOf(new String[]{r100});
        r101.getClass();
        a(li5.c.a(r104, r103, r105).subscribe(new h(this, r100), new i(this)));
    }

    public SharePermissionViewModel(p r100) {
        Intrinsics.checkNotNullParameter(r100, "configComment");
        this.f232153c = r100;
        this.f232154d = "Comment#SharePermissionViewModel";
        this.f232156f = new LinkedHashMap();
        this.f232157g = new MutableLiveData(PreviewPermissionState.STATE_INIT);
        com.bytedance.ee.bear.appsetting.c r101 = com.bytedance.ee.bear.appsetting.c.a.f206237a;
        if (r101.g("ccm.mention.optimizing_authorizaiton_v2") == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        this.f232159i = r102;
        n();
        return;
    L5:
        if (r101.g("ccm.mention.optimizing_authorizaiton") == false) goto L7;
        r102 = true;
        goto L8
    }

    public static void o(TextView r100) {
        r100.invalidate();
        if ((r100 instanceof CommentEditText) == false) goto L14;
        CommentEditText r101 = (CommentEditText) r100;
        if ((r101.getText() instanceof SpannableStringBuilder) == false) goto L15;
        Editable r102 = r101.getText();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.text.SpannableStringBuilder");
        SpannableStringBuilder r103 = (SpannableStringBuilder) r102;
        l[] r104 = (l[]) r103.getSpans(0, r103.length(), l.class);
        Intrinsics.checkNotNull(r104);
        if (r104.length != 0) goto L9;
        boolean r105 = true;
    L11:
        if ((!r105) == false) goto L16;
        l r106 = r104[0];
        int r107 = r103.getSpanStart(r106);
        int r108 = r103.getSpanEnd(r106);
        r103.removeSpan(r106);
        r106.getClass();
        r103.setSpan(r106, r107, r108, 33);
        return;
    L16:
        return;
    L9:
        r105 = false;
        goto L11
    L15:
        return;
    }

    public final void l(List<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "userIds");
        Iterator<T> r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        String r102 = (String) r101.next();
        this.f232156f.remove(r102);
        goto L4
    }

    public final void f(String r100, Function2 r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "callback");
        if (this.f232156f.containsKey(r100) == false) goto L5;
        ((LinkedHashMap) this.f232156f).get(r100);
    L5:
        j r102 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r103 = this.f232153c;
        String r104 = r103.f232233i;
        int r105 = r103.f232235k.f541317b;
        ArrayList r106 = CollectionsKt.arrayListOf(new String[]{r100});
        r102.getClass();
        a(li5.c.a(r105, r104, r106).subscribe(new mf5.c(r100, this, r101), new mf5.d(this)));
    }

    public final void g(List r100, Function1 r101) {
        Intrinsics.checkNotNullParameter(r100, "userIds");
        Intrinsics.checkNotNullParameter(r101, "callback");
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((!StringsKt.isBlank((String) r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        List r105 = CollectionsKt.distinct(r102);
        if (r105.isEmpty() == false) goto L12;
        r101.invoke(MapsKt.emptyMap());
        return;
    L12:
        LinkedHashMap r106 = new LinkedHashMap();
        ArrayList r107 = new ArrayList();
        Iterator r108 = r105.iterator();
    L14:
        if (r108.hasNext() == false) goto L17;
        String r109 = (String) r108.next();
        IDocUserPermission r110 = (IDocUserPermission) ((LinkedHashMap) this.f232156f).get(r109);
        r107.add(r109);
        goto L14
    L17:
        if (r107.isEmpty() == false) goto L20;
        r101.invoke(r106);
        return;
    L20:
        j r111 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r112 = this.f232153c;
        String r113 = r112.f232233i;
        int r114 = r112.f232235k.f541317b;
        ArrayList r115 = new ArrayList(r107);
        r111.getClass();
        Flowable<HashMap<String, IDocUserPermission>> r116 = li5.c.a(r114, r113, r115);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.comment.request_permission_if_no_cache") == false) goto L23;
        r116 = r116.retry(1);
    L23:
        a(r116.subscribe(new com.bytedance.ee.bear.middleground.comment.share.a(this, r107, r101, r106), new com.bytedance.ee.bear.middleground.comment.share.b(this, r101, r106)));
    }

    public final void j(List r110, e1 r111) {
        Intrinsics.checkNotNullParameter(r110, "userIds");
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (this.f232153c.f232236l == false) goto L5;
        int r100 = 2;
    L6:
        List r101 = r110;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = r101.iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        String r104 = (String) r103.next();
        UserInfo r105 = new UserInfo();
        r105.setId(r104);
        r105.setOwnerType(1);
        r102.add(r105);
        goto L8
    L10:
        p r106 = this.f232153c;
        int r107 = r100;
        com.bytedance.ee.bear.middleground.permission.collaborator.invite.g r108 = new com.bytedance.ee.bear.middleground.permission.collaborator.invite.g(r107, r106.f232234j, r106.f232235k.f541317b, r106.f232233i, true);
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().g(r108, r102, new mf5.e(r111, this, r110));
        return;
    L5:
        r100 = 1;
        goto L6
    }

    public final void m(p r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "config");
        Intrinsics.checkNotNullParameter(r111, "token");
        tt5.a.h(this.f232154d, "requestFilePreviewPermission: start");
        if (this.f232158h == false) goto L5;
        return;
    L5:
        this.f232158h = true;
        tt5.a.h(this.f232154d, "requestFilePreviewPermission: in");
        j r100 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        int r101 = sbb.e.f541301l.f541317b;
        String r102 = r110.f232233i;
        int r103 = r110.f232235k.f541317b;
        r100.getClass();
        wh5.d r104 = new wh5.d();
        Intrinsics.checkNotNullParameter(r111, "token");
        Intrinsics.checkNotNullParameter(r102, "parentToken");
        a(Flowable.create(new wh5.f(r111, r101, r102, r103, r104), BackpressureStrategy.BUFFER).subscribeOn(fo5.d.b()).timeout(20000, TimeUnit.MILLISECONDS).observeOn(fo5.d.d()).subscribe(new f(r111, this), new g(this)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v4, types: [T, un5.l[]] */
    public final void i(TextView r110, boolean r111, Function1<? super l, Unit> r112) {
        Intrinsics.checkNotNullParameter(r110, "textView");
        if (this.f232153c.B == true) goto L5;
        return;
    L5:
        boolean r100 = false;
        if (r110.getText().length() != 0) goto L8;
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return;
    L11:
        Ref.ObjectRef r102 = new Ref.ObjectRef();
        CharSequence r103 = r110.getText();
        if ((r103 instanceof Spanned) == false) goto L14;
        Spanned r104 = (Spanned) r103;
    L15:
        if (r104 != null) goto L17;
        return;
    L17:
        ?? r105 = (l[]) r104.getSpans(0, r110.getText().length(), l.class);
        if (r105 != 0) goto L20;
        return;
    L20:
        r102.element = r105;
        ArrayList r106 = new ArrayList();
        l[] r107 = (l[]) r102.element;
        int r108 = r107.length;
        int r109 = 0;
    L21:
        if (r109 >= r108) goto L70;
        l r113 = r107[r109];
        if (this.f232156f.containsKey(r113.f550815d) == false) goto L66;
        IDocUserPermission r114 = (IDocUserPermission) ((LinkedHashMap) this.f232156f).get(r113.f550815d);
        if (r114 != null) goto L27;
    L63:
        if (r111 == true) goto L68;
        r106.add(r113.f550815d);
    L68:
        r109 = r109 + 1;
        goto L21
    L27:
        if (this.f232159i == false) goto L44;
        if (r114.canRead() == false) goto L31;
    L33:
        boolean r115 = false;
    L34:
        r113.f550821j = r115;
        IDocUserPermission r116 = this.f232155e;
        if (r116 != null) goto L37;
    L39:
        boolean r117 = false;
    L40:
        r113.f550822k = r117;
        if (r112 == null) goto L63;
        Intrinsics.checkNotNull(r113);
        r112.invoke(r113);
        goto L63
    L37:
        if (r116.canManageCollaborator() != true) goto L39;
        r117 = true;
        goto L40
    L31:
        if (r114.canPerceive() == true) goto L33;
        r115 = true;
        goto L34
    L44:
        if (r114.canRead() == false) goto L46;
    L55:
        boolean r118 = false;
    L56:
        r113.f550821j = r118;
        IDocUserPermission r119 = this.f232155e;
        if (r119 != null) goto L59;
    L61:
        boolean r120 = false;
    L62:
        r113.f550822k = r120;
        goto L63
    L59:
        if (r119.canManageCollaborator() != true) goto L61;
        r120 = true;
        goto L62
    L46:
        if (r114.canPerceive() == true) goto L55;
        IDocUserPermission r121 = this.f232155e;
        if (r121 != null) goto L50;
    L52:
        boolean r122 = false;
    L53:
        if (r122 == false) goto L55;
        r118 = true;
        goto L56
    L50:
        if (r121.canManageCollaborator() != true) goto L52;
        r122 = true;
        goto L53
    L66:
        if (r106.contains(r113.f550815d) == true) goto L68;
        r106.add(r113.f550815d);
        goto L68
    L70:
        if (r106.size() != 0) goto L78;
        if (((Object[]) r102.element).length != 0) goto L75;
        r100 = true;
    L75:
        if ((!r100) == false) goto L78;
        o(r110);
    L78:
        if (r106.size() == 0) goto L83;
        ArrayList r123 = new ArrayList();
        r123.addAll(CollectionsKt.take(r106, 10));
        r106.removeAll(r123);
        j r124 = ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa();
        p r125 = this.f232153c;
        String r126 = r125.f232233i;
        int r127 = r125.f232235k.f541317b;
        r124.getClass();
        Flowable<HashMap<String, IDocUserPermission>> r128 = li5.c.a(r127, r126, r123);
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.comment.request_permission_if_no_cache") == false) goto L82;
        r128 = r128.retry(1);
    L82:
        a(r128.subscribe(new c(this, r102, r110, r112), new d(this)));
        goto L78
    L83:
        return;
    L14:
        r104 = null;
        goto L15
    L8:
        r101 = false;
        goto L9
    }

    public final void k(String r100, boolean r110, bf5.b r111) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r111, "callback");
        if (this.f232153c.f232236l == false) goto L5;
        int r101 = 2;
    L6:
        UserInfo r102 = new UserInfo();
        r102.setId(r100);
        r102.setOwnerType(1);
        Unit r103 = Unit.INSTANCE;
        ArrayList r104 = CollectionsKt.arrayListOf(new UserInfo[]{r102});
        p r105 = this.f232153c;
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).aa().g(new com.bytedance.ee.bear.middleground.permission.collaborator.invite.g(r101, r105.f232234j, r105.f232235k.f541317b, r105.f232233i, r110), r104, new e(this, r100, r111));
        return;
    L5:
        r101 = 1;
        goto L6
    }
}
