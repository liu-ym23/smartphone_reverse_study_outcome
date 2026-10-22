package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.text.Spanned;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.comment.permission.AskOwnerViewModel;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentVoiceMentionPermissionHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f230372d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.ee.bear.middleground.comment.uitls.p f230373a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SharePermissionViewModel f230374b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f230375c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper$a$a, reason: collision with other inner class name */
        public static final class C3295a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f230376a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f230377b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public final int f230378c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public final int f230379d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public final List<String> f230380e;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3295a) == true) goto L8;
                return false;
            L8:
                C3295a r101 = (C3295a) r100;
                if (this.f230376a == r101.f230376a) goto L12;
                return false;
            L12:
                if (this.f230377b == r101.f230377b) goto L15;
                return false;
            L15:
                if (this.f230378c == r101.f230378c) goto L18;
                return false;
            L18:
                if (this.f230379d == r101.f230379d) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.f230380e, r101.f230380e) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                if (this.f230376a == false) goto L5;
                int r100 = 1231;
            L7:
                return (((((((r100 * 31) + this.f230377b) * 31) + this.f230378c) * 31) + this.f230379d) * 31) + this.f230380e.hashCode();
            L5:
                r100 = 1237;
                goto L7
            }

            public final String toString() {
                return "PermissionDialogConfig(shouldShow=" + this.f230376a + ", titleRes=" + this.f230377b + ", primaryButtonRes=" + this.f230378c + ", secondaryButtonRes=" + this.f230379d + ", requestUserIds=" + this.f230380e + ')';
            }

            public /* synthetic */ C3295a(boolean r100, int r101, int r102, int r110, int r111) {
                if ((r111 & 2) == 0) goto L5;
                int r103 = R.string.LarkCCM_MobileComment_MentionAccess_Title;
            L7:
                if ((r111 & 4) == 0) goto L9;
                int r104 = R.string.LarkCCM_MobileComment_GrantAccess_Button;
            L11:
                if ((r111 & 8) == 0) goto L13;
                int r105 = R.string.LarkCCM_MobileComment_NotNow_Button;
            L15:
                if ((r111 & 16) == 0) goto L17;
                List r106 = CollectionsKt.emptyList();
            L18:
                this(r100, r103, r104, r105, r106);
                return;
            L17:
                r106 = null;
                goto L18
            L13:
                r105 = r110;
                goto L15
            L9:
                r104 = r102;
                goto L11
            L5:
                r103 = r101;
                goto L7
            }

            public C3295a(boolean r100, int r101, int r102, int r103, List<String> r104) {
                Intrinsics.checkNotNullParameter(r104, "requestUserIds");
                this.f230376a = r100;
                this.f230377b = r101;
                this.f230378c = r102;
                this.f230379d = r103;
                this.f230380e = r104;
            }
        }
    }

    static {
    }

    public static List a(CharSequence r100) {
        if ((r100 instanceof Spanned) == false) goto L5;
        Spanned r101 = (Spanned) r100;
    L6:
        if (r101 == null) goto L8;
        int r102 = 0;
        Object[] r103 = r101.getSpans(0, r100.length(), un5.l.class);
        ArrayList r104 = new ArrayList(r103.length);
        int r105 = r103.length;
    L10:
        if (r102 >= r105) goto L12;
        r104.add(((un5.l) r103[r102]).f550815d);
        r102 = r102 + 1;
        goto L10
    L12:
        ArrayList r106 = new ArrayList();
        Iterator r107 = r104.iterator();
    L14:
        if (r107.hasNext() == false) goto L19;
        Object r108 = r107.next();
        String r109 = (String) r108;
        Intrinsics.checkNotNull(r109);
        if ((!StringsKt.isBlank(r109)) == false) goto L14;
        r106.add(r108);
        goto L14
    L19:
        return CollectionsKt.distinct(r106);
    L8:
        return CollectionsKt.emptyList();
    L5:
        r101 = null;
        goto L6
    }

    public CommentVoiceMentionPermissionHelper(com.bytedance.ee.bear.middleground.comment.uitls.p r100, SharePermissionViewModel r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "sharePermissionViewModel");
        this.f230373a = r100;
        this.f230374b = r101;
        this.f230375c = com.bytedance.ee.bear.appsetting.c.a.f206237a.g("ccm.mobile.comment_batch_askowner");
    }

    public final void b(CharSequence r100, final Function1<? super Boolean, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r101, "onResolved");
        if (this.f230373a.B == true) goto L6;
        tt5.a.h("Comment#VoiceMentionPermission", "usePermissionShare is false, skip confirmBeforeSend");
        r101.invoke(Boolean.FALSE);
        return;
    L6:
        final List r102 = a(r100);
        if (r102.isEmpty() == false) goto L10;
        tt5.a.h("Comment#VoiceMentionPermission", "no mention user found, skip confirmBeforeSend");
        r101.invoke(Boolean.FALSE);
        return;
    L10:
        this.f230374b.g(r102, new CommentVoiceMentionPermissionHelper$confirmBeforeSend$1(r102, this, r101));
    }

    public final void c(List<String> r100, final Function1<? super Map<String, Boolean>, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, "userIds");
        Intrinsics.checkNotNullParameter(r101, "onResolved");
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if ((!StringsKt.isBlank((String) r104)) == false) goto L4;
        r102.add(r104);
        goto L4
    L8:
        List r105 = CollectionsKt.distinct(r102);
        if (r105.isEmpty() == false) goto L13;
        r101.invoke(MapsKt.emptyMap());
        return;
    L13:
        if (this.f230373a.B == true) goto L20;
        List r106 = r105;
        LinkedHashMap r107 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r106, 10)), 16));
        Iterator r108 = r106.iterator();
    L16:
        if (r108.hasNext() == false) goto L18;
        Object r109 = r108.next();
        String r110 = (String) r109;
        r107.put(r109, Boolean.TRUE);
        goto L16
    L18:
        r101.invoke(r107);
        return;
    L20:
        this.f230374b.g(r105, new CommentVoiceMentionPermissionHelper$fetchMentionUserReadPermissions$2(r101));
    }

    public final void d(List<String> r100, final Function1<? super Boolean, Unit> r101) {
        SharePermissionViewModel r102 = this.f230374b;
        Function1<Throwable, Unit> r103 = new CommentVoiceMentionPermissionHelper$requestMentionUserReadPermissions$1(this, r101);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "userIds");
        Intrinsics.checkNotNullParameter(r103, "callback");
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r100.iterator();
    L4:
        if (r105.hasNext() == false) goto L8;
        Object r106 = r105.next();
        if ((!StringsKt.isBlank((String) r106)) == false) goto L4;
        r104.add(r106);
        goto L4
    L8:
        List<String> r107 = CollectionsKt.distinct(r104);
        if (r107.isEmpty() == false) goto L11;
        r103.invoke(null);
        return;
    L11:
        AskOwnerViewModel r108 = new AskOwnerViewModel();
        r108.init((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        com.bytedance.ee.bear.middleground.comment.uitls.p r109 = r102.f232153c;
        r102.a(r108.askDocumentOwnerFlow(r109.f232233i, r109.f232235k.f541317b, r107).subscribe(new mf5.f(r103), new mf5.g(r102, r103)));
    }

    public final void e(CharSequence r100, final boolean r101, final Function1<? super Boolean, Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "content");
        Intrinsics.checkNotNullParameter(r102, "onResolved");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L14;
        if (r101 == false) goto L14;
        if (this.f230374b.e() == true) goto L14;
        final List r103 = a(r100);
        if (r103.isEmpty() == false) goto L12;
        r102.invoke(Boolean.valueOf(r101));
        return;
    L12:
        this.f230374b.g(r103, new CommentVoiceMentionPermissionHelper$resolveBeforeSend$1(r103, this, r102, r101));
        return;
    L14:
        r102.invoke(Boolean.valueOf(r101));
    }
}
