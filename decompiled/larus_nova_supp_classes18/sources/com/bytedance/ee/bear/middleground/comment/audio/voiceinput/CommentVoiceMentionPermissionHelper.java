package com.bytedance.ee.bear.middleground.comment.audio.voiceinput;

import android.text.Spanned;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.middleground.comment.permission.AskOwnerViewModel;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceMentionPermissionHelper {
    public static final /* synthetic */ int d = 0;
    public final com.bytedance.ee.bear.middleground.comment.uitls.p a;
    public final SharePermissionViewModel b;
    public final boolean c;

    public static final class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.audio.voiceinput.CommentVoiceMentionPermissionHelper$a$a, reason: collision with other inner class name */
        public static final class C0048a {
            public final boolean a;
            public final int b;
            public final int c;
            public final int d;
            public final List<String> e;

            public final boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if ((r5 instanceof C0048a) == true) goto L8;
                return false;
            L8:
                C0048a r6 = (C0048a) r5;
                if (this.a == r6.a) goto L12;
                return false;
            L12:
                if (this.b == r6.b) goto L15;
                return false;
            L15:
                if (this.c == r6.c) goto L18;
                return false;
            L18:
                if (this.d == r6.d) goto L21;
                return false;
            L21:
                if (Intrinsics.areEqual(this.e, r6.e) == true) goto L23;
                return false;
            L23:
                return true;
            }

            public final int hashCode() {
                if (this.a == false) goto L5;
                int r0 = 1231;
            L7:
                return (((((((r0 * 31) + this.b) * 31) + this.c) * 31) + this.d) * 31) + this.e.hashCode();
            L5:
                r0 = 1237;
                goto L7
            }

            public final String toString() {
                return "PermissionDialogConfig(shouldShow=" + this.a + ", titleRes=" + this.b + ", primaryButtonRes=" + this.c + ", secondaryButtonRes=" + this.d + ", requestUserIds=" + this.e + ')';
            }

            public /* synthetic */ C0048a(boolean r7, int r8, int r9, int r10, int r11) {
                if ((r11 & 2) == 0) goto L5;
                int r2 = 2131889563;
            L7:
                if ((r11 & 4) == 0) goto L9;
                int r3 = 2131889562;
            L11:
                if ((r11 & 8) == 0) goto L13;
                int r4 = 2131889564;
            L15:
                if ((r11 & 16) == 0) goto L17;
                List r12 = CollectionsKt.emptyList();
            L18:
                this(r7, r2, r3, r4, r12);
                return;
            L17:
                r12 = null;
                goto L18
            L13:
                r4 = r10;
                goto L15
            L9:
                r3 = r9;
                goto L11
            L5:
                r2 = r8;
                goto L7
            }

            public C0048a(boolean r2, int r3, int r4, int r5, List<String> r6) {
                Intrinsics.checkNotNullParameter(r6, "requestUserIds");
                this.a = r2;
                this.b = r3;
                this.c = r4;
                this.d = r5;
                this.e = r6;
            }
        }
    }

    static {
    }

    public static List a(CharSequence r4) {
        if ((r4 instanceof Spanned) == false) goto L5;
        Spanned r0 = (Spanned) r4;
    L6:
        if (r0 == null) goto L8;
        int r2 = 0;
        Object[] r5 = r0.getSpans(0, r4.length(), un5.l.class);
        ArrayList r1 = new ArrayList(r5.length);
        int r3 = r5.length;
    L10:
        if (r2 >= r3) goto L12;
        r1.add(((un5.l) r5[r2]).d);
        r2 = r2 + 1;
        goto L10
    L12:
        ArrayList r6 = new ArrayList();
        Iterator r7 = r1.iterator();
    L14:
        if (r7.hasNext() == false) goto L19;
        Object r8 = r7.next();
        String r9 = (String) r8;
        Intrinsics.checkNotNull(r9);
        if ((!StringsKt.isBlank(r9)) == false) goto L14;
        r6.add(r8);
        goto L14
    L19:
        return CollectionsKt.distinct(r6);
    L8:
        return CollectionsKt.emptyList();
    L5:
        r0 = null;
        goto L6
    }

    public CommentVoiceMentionPermissionHelper(com.bytedance.ee.bear.middleground.comment.uitls.p r2, SharePermissionViewModel r3) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "sharePermissionViewModel");
        this.a = r2;
        this.b = r3;
        this.c = com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.comment_batch_askowner");
    }

    public final void b(CharSequence r3, final Function1<? super Boolean, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r4, "onResolved");
        if (this.a.B == true) goto L6;
        tt5.a.h("Comment#VoiceMentionPermission", "usePermissionShare is false, skip confirmBeforeSend");
        r4.invoke(Boolean.FALSE);
        return;
    L6:
        final List r5 = a(r3);
        if (r5.isEmpty() == false) goto L10;
        tt5.a.h("Comment#VoiceMentionPermission", "no mention user found, skip confirmBeforeSend");
        r4.invoke(Boolean.FALSE);
        return;
    L10:
        this.b.g(r5, new CommentVoiceMentionPermissionHelper$confirmBeforeSend$1(r5, this, r4));
    }

    public final void c(List<String> r4, final Function1<? super Map<String, Boolean>, Unit> r5) {
        Intrinsics.checkNotNullParameter(r4, "userIds");
        Intrinsics.checkNotNullParameter(r5, "onResolved");
        ArrayList r0 = new ArrayList();
        Iterator<T> r6 = r4.iterator();
    L4:
        if (r6.hasNext() == false) goto L8;
        Object r1 = r6.next();
        if ((!StringsKt.isBlank((String) r1)) == false) goto L4;
        r0.add(r1);
        goto L4
    L8:
        List r7 = CollectionsKt.distinct(r0);
        if (r7.isEmpty() == false) goto L13;
        r5.invoke(MapsKt.emptyMap());
        return;
    L13:
        if (this.a.B == true) goto L20;
        List r8 = r7;
        LinkedHashMap r2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r8, 10)), 16));
        Iterator r9 = r8.iterator();
    L16:
        if (r9.hasNext() == false) goto L18;
        Object r3 = r9.next();
        String r10 = (String) r3;
        r2.put(r3, Boolean.TRUE);
        goto L16
    L18:
        r5.invoke(r2);
        return;
    L20:
        this.b.g(r7, new CommentVoiceMentionPermissionHelper$fetchMentionUserReadPermissions$2(r5));
    }

    public final void d(List<String> r6, final Function1<? super Boolean, Unit> r7) {
        SharePermissionViewModel r0 = this.b;
        Function1<Throwable, Unit> r1 = new CommentVoiceMentionPermissionHelper$requestMentionUserReadPermissions$1(this, r7);
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "userIds");
        Intrinsics.checkNotNullParameter(r1, "callback");
        ArrayList r8 = new ArrayList();
        Iterator<T> r9 = r6.iterator();
    L4:
        if (r9.hasNext() == false) goto L8;
        Object r2 = r9.next();
        if ((!StringsKt.isBlank((String) r2)) == false) goto L4;
        r8.add(r2);
        goto L4
    L8:
        List<String> r10 = CollectionsKt.distinct(r8);
        if (r10.isEmpty() == false) goto L11;
        r1.invoke(null);
        return;
    L11:
        AskOwnerViewModel r11 = new AskOwnerViewModel();
        r11.init((NetService) org.koin.java.a.c(NetService.class, null, null, 6));
        com.bytedance.ee.bear.middleground.comment.uitls.p r3 = r0.c;
        r0.a(r11.askDocumentOwnerFlow(r3.i, r3.k.b, r10).subscribe(new mf5.f(r1), new mf5.g(r0, r1)));
    }

    public final void e(CharSequence r3, final boolean r4, final Function1<? super Boolean, Unit> r5) {
        Intrinsics.checkNotNullParameter(r3, "content");
        Intrinsics.checkNotNullParameter(r5, "onResolved");
        if (com.bytedance.ee.bear.middleground.comment.export.e.b() == false) goto L14;
        if (r4 == false) goto L14;
        if (this.b.e() == true) goto L14;
        final List r6 = a(r3);
        if (r6.isEmpty() == false) goto L12;
        r5.invoke(Boolean.valueOf(r4));
        return;
    L12:
        this.b.g(r6, new CommentVoiceMentionPermissionHelper$resolveBeforeSend$1(r6, this, r5, r4));
        return;
    L14:
        r5.invoke(Boolean.valueOf(r4));
    }
}
