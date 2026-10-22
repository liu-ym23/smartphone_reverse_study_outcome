package com.larus.office.card.urlpreview;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.activity.result.ActivityResultCaller;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.block.ArtifactBlock;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.api.IFlowOfficeWikiTokenResolver;
import com.larus.platform.service.n3;
import com.larus.utils.logger.FLogger;
import com.ss.android.download.api.config.HttpMethod;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class OfficeUrlPreviewActionInterceptor implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f361667a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f361668b = null;

    /* JADX INFO: loaded from: classes29.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0082\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/office/card/urlpreview/OfficeUrlPreviewActionInterceptor$Action;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "COPY", HttpMethod.DOWNLOAD, "OPEN", "EXPAND", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Action extends Enum<Action> {
        public static final Action COPY = null;
        public static final a Companion = null;
        public static final Action DOWNLOAD = null;
        public static final Action EXPAND = null;
        public static final Action OPEN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f361669a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f361670b = null;
        private final String value;

        public static final class a {
            public a() {
            }

            public static Action a(String r100) {
                Action r101 = Action.COPY;
                if (Intrinsics.areEqual(r100, r101.getValue()) == true) goto L16;
                Action r102 = Action.DOWNLOAD;
                if (Intrinsics.areEqual(r100, r102.getValue()) == true) goto L17;
                Action r103 = Action.OPEN;
                if (Intrinsics.areEqual(r100, r103.getValue()) == true) goto L18;
                Action r104 = Action.EXPAND;
                if (Intrinsics.areEqual(r100, r104.getValue()) == true) goto L19;
                return null;
            L19:
                return r104;
            L18:
                return r103;
            L17:
                return r102;
            L16:
                return r101;
            }
        }

        public static EnumEntries<Action> getEntries() {
            return f361670b;
        }

        static {
            Action r100 = new Action("COPY", 0, "copy");
            COPY = r100;
            Action r101 = new Action(HttpMethod.DOWNLOAD, 1, "download");
            DOWNLOAD = r101;
            Action r102 = new Action("OPEN", 2, "open");
            OPEN = r102;
            Action r103 = new Action("EXPAND", 3, BitableAnalytic.LinkSceneClickType.EXPAND);
            EXPAND = r103;
            Action[] r104 = {r100, r101, r102, r103};
            f361669a = r104;
            f361670b = EnumEntriesKt.enumEntries(r104);
            Companion = new a();
        }

        public static Action[] values() {
            return (Action[]) f361669a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public Action(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static final class a {
    }

    /* JADX INFO: loaded from: classes29.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361671a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f361672b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f361673c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f361671a, r101.f361671a) == true) goto L12;
            return false;
        L12:
            if (this.f361672b == r101.f361672b) goto L15;
            return false;
        L15:
            if (this.f361673c == r101.f361673c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f361671a.hashCode() * 31) + this.f361672b) * 31;
            if (this.f361673c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ResolvedResource(resourceId=" + this.f361671a + ", resourceType=" + this.f361672b + ", fromWiki=" + this.f361673c + ')';
        }

        public b(String r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "resourceId");
            this.f361671a = r100;
            this.f361672b = r101;
            this.f361673c = r102;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361674a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f361675b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f361676c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f361677d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Integer f361678e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f361679f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f361680g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f361681h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f361682i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f361683j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f361684k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f361685l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f361686m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f361687n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final String f361688o;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f361674a, r101.f361674a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361675b, r101.f361675b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f361676c, r101.f361676c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f361677d, r101.f361677d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f361678e, r101.f361678e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f361679f, r101.f361679f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f361680g, r101.f361680g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f361681h, r101.f361681h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f361682i, r101.f361682i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f361683j, r101.f361683j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f361684k, r101.f361684k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f361685l, r101.f361685l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f361686m, r101.f361686m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f361687n, r101.f361687n) == true) goto L51;
            return false;
        L51:
            if (Intrinsics.areEqual(this.f361688o, r101.f361688o) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f361674a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Integer r104 = this.f361675b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f361676c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f361677d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            Integer r113 = this.f361678e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f361679f;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f361680g;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            String r122 = this.f361681h;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.f361682i;
            if (r125 != null) goto L37;
            int r126 = 0;
        L38:
            int r127 = (r124 + r126) * 31;
            String r128 = this.f361683j;
            if (r128 != null) goto L41;
            int r129 = 0;
        L42:
            int r130 = (r127 + r129) * 31;
            String r131 = this.f361684k;
            if (r131 != null) goto L45;
            int r132 = 0;
        L46:
            int r133 = (r130 + r132) * 31;
            String r134 = this.f361685l;
            if (r134 != null) goto L49;
            int r135 = 0;
        L50:
            int r136 = (r133 + r135) * 31;
            String r137 = this.f361686m;
            if (r137 != null) goto L53;
            int r138 = 0;
        L54:
            int r139 = (r136 + r138) * 31;
            String r140 = this.f361687n;
            if (r140 != null) goto L57;
            int r141 = 0;
        L58:
            int r142 = (r139 + r141) * 31;
            String r143 = this.f361688o;
            if (r143 == null) goto L63;
            r101 = r143.hashCode();
        L63:
            return r142 + r101;
        L57:
            r141 = r140.hashCode();
            goto L58
        L53:
            r138 = r137.hashCode();
            goto L54
        L49:
            r135 = r134.hashCode();
            goto L50
        L45:
            r132 = r131.hashCode();
            goto L46
        L41:
            r129 = r128.hashCode();
            goto L42
        L37:
            r126 = r125.hashCode();
            goto L38
        L33:
            r123 = r122.hashCode();
            goto L34
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ResourceActionMetadata(title=" + this.f361674a + ", resourceVersion=" + this.f361675b + ", artifactMetaId=" + this.f361676c + ", trackingResourceId=" + this.f361677d + ", trackingResourceType=" + this.f361678e + ", messageId=" + this.f361679f + ", conversationId=" + this.f361680g + ", sectionId=" + this.f361681h + ", botId=" + this.f361682i + ", recordId=" + this.f361683j + ", recordingContentType=" + this.f361684k + ", recordScene=" + this.f361685l + ", isGeneralAgent=" + this.f361686m + ", chatId=" + this.f361687n + ", previousPage=" + this.f361688o + ')';
        }

        public c(String r100, Integer r101, String r102, String r103, Integer r104, String r105, String r106, String r107, String r108, String r110, String r111, String r112, String r113, String r114, String r115) {
            this.f361674a = r100;
            this.f361675b = r101;
            this.f361676c = r102;
            this.f361677d = r103;
            this.f361678e = r104;
            this.f361679f = r105;
            this.f361680g = r106;
            this.f361681h = r107;
            this.f361682i = r108;
            this.f361683j = r110;
            this.f361684k = r111;
            this.f361685l = r112;
            this.f361686m = r113;
            this.f361687n = r114;
            this.f361688o = r115;
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f361689a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f361690b = null;

        static {
            int[] r100 = new int[Action.values().length];
            r100[Action.OPEN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L26:
            r100[Action.EXPAND.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L34:
            r100[Action.COPY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L28:
            r100[Action.DOWNLOAD.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L9:
            f361689a = r100;
            int[] r101 = new int[OfficeUrlPreviewSourceKind.values().length];
            r101[OfficeUrlPreviewSourceKind.MARKDOWN.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L30:
            r101[OfficeUrlPreviewSourceKind.HTML.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L22:
            r101[OfficeUrlPreviewSourceKind.OFFICE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L13:
            f361690b = r101;
        }
    }

    public OfficeUrlPreviewActionInterceptor() {
    }

    static {
        f361667a = SetsKt.setOf(new Integer[]{10, 11, 17});
        f361668b = SetsKt.setOf(new Integer[]{0, 9, 10, 12, 14, 17});
    }

    public static Fragment e(Context r100) {
        if ((r100 instanceof FragmentActivity) == false) goto L5;
        FragmentActivity r101 = (FragmentActivity) r100;
    L6:
        if (r101 != null) goto L14;
        gd9.i r102 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r102);
        Activity r103 = r102.a().e();
        if ((r103 instanceof FragmentActivity) == false) goto L10;
        r101 = (FragmentActivity) r103;
    L11:
        if (r101 != null) goto L14;
        return null;
    L10:
        r101 = null;
    L14:
        return f(r101.getSupportFragmentManager());
    L5:
        r101 = null;
        goto L6
    }

    public static Fragment f(FragmentManager r100) {
        Fragment r101 = r100.getPrimaryNavigationFragment();
        if (r101 != null) goto L5;
    L15:
        Iterator r102 = CollectionsKt.asReversedMutable(r100.getFragments()).iterator();
    L17:
        if (r102.hasNext() == false) goto L26;
        Object r103 = r102.next();
        Fragment r104 = (Fragment) r103;
        if (r104.isAdded() == true) goto L21;
    L23:
        boolean r105 = false;
    L24:
        if (r105 == false) goto L17;
    L27:
        r101 = (Fragment) r103;
        if (r101 != null) goto L30;
        return null;
    L30:
        Fragment r106 = f(r101.getChildFragmentManager());
        if (r106 != null) goto L34;
        return r101;
    L34:
        return r106;
    L21:
        if (r104.isHidden() == true) goto L23;
        r105 = true;
        goto L24
    L26:
        r103 = null;
        goto L27
    L5:
        if (r101.isAdded() == true) goto L7;
    L9:
        boolean r107 = false;
    L10:
        if (r107 == true) goto L13;
        r101 = null;
    L13:
        if (r101 == null) goto L15;
    L7:
        if (r101.isHidden() == true) goto L9;
        r107 = true;
        goto L10
    }

    public static void k(c r100) {
        String r101 = r100.f361687n;
        String r102 = r100.f361679f;
        JSONObject r103 = new JSONObject();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r103.put("chat_id", r101);
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        r103.put(MusicAppletPage.KEY_MESSAGE_ID, r102);
        by7.a r104 = new by7.a("copy");
        TrackParams r105 = new TrackParams().merge(r103);
        r104.f21463a.merge(r105);
        r104.b();
    }

    @Override // q97.a
    public final boolean b(com.bytedance.router.c r100) {
        if (r100 == null) goto L12;
        Uri r101 = r100.f267530d;
        if (r101 == null) goto L12;
        int r102 = com.larus.utils.k0.f375428a;
        String r103 = com.larus.utils.k0.a(r101.toString());
        if (Intrinsics.areEqual(r103, "//flow/office_url_preview_action") == false) goto L10;
        return true;
    L10:
        if (Intrinsics.areEqual(r103, "//flow/doc/office_card_action") == false) goto L12;
        return StringsKt.equals(r101.getScheme(), AppConstants.SCHEME_SS_LOCAL, true);
    L12:
        return false;
    }

    public static Integer h(com.bytedance.router.c r100, String r101) {
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L10;
        String r103 = UriProtector.getQueryParameter(r102, r101);
        if (r103 == null) goto L10;
        Integer r104 = StringsKt.toIntOrNull(r103);
        if (r104 == null) goto L10;
        return Integer.valueOf(r104.intValue());
    L10:
        Intent r105 = r100.f267528b;
        if (r105 != null) goto L14;
        return null;
    L14:
        if (r105.hasExtra(r101) == true) goto L16;
        return null;
    L16:
        Integer r106 = Integer.valueOf(r105.getIntExtra(r101, Integer.MIN_VALUE));
        if (r106.intValue() == Integer.MIN_VALUE) goto L19;
        boolean r107 = true;
    L20:
        if (r107 == true) goto L23;
        r106 = null;
    L23:
        if (r106 != null) goto L25;
        String r108 = r105.getStringExtra(r101);
        if (r108 != null) goto L29;
        return null;
    L29:
        return StringsKt.toIntOrNull(r108);
    L25:
        return Integer.valueOf(r106.intValue());
    L19:
        r107 = false;
        goto L20
    }

    public static void l(Fragment r100, Action r101) {
        if (r101 != Action.COPY) goto L5;
        int r102 = R.string.larus_aiDoc_copyFailed_errorMsg;
    L6:
        t19.s r103 = t19.s.f544207a;
        Context r104 = r100.getContext();
        if (r104 != null) goto L9;
        gd9.i r105 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r105);
        r104 = r105.getApplication();
    L9:
        r103.getClass();
        t19.s.s(r104, r102);
        return;
    L5:
        r102 = R.string.larus_aiDoc_downloadFailed_errorMsg;
        goto L6
    }

    public static String m(Uri r100, String r101) {
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L4
        Object r103 = Result.m9449constructorimpl(UriProtector.getQueryParameters(r100, r101));     // Catch: Throwable -> L4
    L7:
        if (Result.m9455isFailureimpl(r103) == false) goto L9;
        r103 = null;
    L9:
        List r104 = (List) r103;
        if (r104 == null) goto L19;
        String r105 = (String) CollectionsKt.singleOrNull(r104);
        if (r105 != null) goto L14;
        return null;
    L14:
        if ((!StringsKt.isBlank(r105)) == true) goto L16;
        return null;
    L16:
        return r105;
    L19:
        return null;
    L4:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    public static String n(com.bytedance.router.c r100, String r101) {
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L13;
        String r103 = UriProtector.getQueryParameter(r102, r101);
        if (r103 == null) goto L13;
        if ((!StringsKt.isBlank(r103)) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L13;
        return r103;
    L13:
        Intent r104 = r100.f267528b;
        if (r104 == null) goto L22;
        String r105 = r104.getStringExtra(r101);
        if (r105 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r105)) == true) goto L20;
        return null;
    L20:
        return r105;
    L22:
        return null;
    }

    @Override // q97.a
    public final boolean a(Context r210, com.bytedance.router.c r310) {
        if (r310 == null) goto L156;
        Uri r100 = r310.f267530d;
        if (r100 == null) goto L171;
        int r101 = com.larus.utils.k0.f375428a;
        String r102 = com.larus.utils.k0.a(r100.toString());
        boolean r103 = false;
        String r104 = null;
        if (Intrinsics.areEqual(r102, "//flow/doc/office_card_action") == false) goto L111;
        if (StringsKt.equals(r100.getScheme(), AppConstants.SCHEME_SS_LOCAL, true) == false) goto L147;
        Action.a r105 = Action.Companion;
        String r106 = m(r100, "action_type");
        r105.getClass();
        Action r107 = Action.a.a(r106);
        if (r107 != null) goto L15;
        FLogger.f375446a.w("OfficeUrlPreviewSDK", "[SDK][action_callback_rejected] reason=invalid_action");
        return true;
    L15:
        String r108 = m(r100, "preview_id");
        if (r108 != null) goto L151;
        FLogger.f375446a.w("OfficeUrlPreviewSDK", "[SDK][action_callback_rejected] action=" + r107 + ", reason=invalid_preview_id");
        return true;
    L151:
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L20
        Object r110 = Result.m9449constructorimpl(UriProtector.getQueryParameters(r100, "resource_token"));     // Catch: Throwable -> L20
    L23:
        if (Result.m9455isFailureimpl(r110) == false) goto L25;
        r110 = null;
    L25:
        List r111 = (List) r110;
        if (r111 != null) goto L28;
        FLogger.f375446a.w("OfficeUrlPreviewSDK", "[SDK][action_callback_rejected] action=" + r107 + ", previewId=" + r108 + ", reason=invalid_resource_token");
        return true;
    L28:
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][action_callback] action=" + r107 + ", previewId=" + r108 + ", resourceTokenCount=" + r111.size());
        if (r111.size() > 1) goto L109;
        List r112 = r111;
        if ((r112 instanceof Collection) == true) goto L33;
    L35:
        Iterator r113 = r112.iterator();
    L37:
        if (r113.hasNext() == false) goto L41;
        if (StringsKt.isBlank((String) r113.next()) == false) goto L37;
        boolean r114 = true;
    L42:
        if (r114 == true) goto L109;
        OfficeUrlPreviewPlatformBridge r115 = OfficeUrlPreviewPlatformBridge.f361768a;
        String r116 = (String) CollectionsKt.singleOrNull(r111);
        monitor-enter(r115);
        Intrinsics.checkNotNullParameter(r108, "previewId");     // Catch: Throwable -> L106
        if (StringsKt.isBlank(r108) == false) goto L50;
        monitor-exit(r115);
    L68:
        com.larus.office.card.urlpreview.d r117 = null;
    L70:
        if (r117 != null) goto L72;
        FLogger.f375446a.w("OfficeUrlPreviewSDK", "[SDK][action_callback_rejected] action=" + r107 + ", previewId=" + r108 + ", reason=target_not_found");
        return true;
    L72:
        FLogger.f375446a.i("OfficeUrlPreviewSDK", "[SDK][action_dispatched] action=" + r107 + ", previewId=" + r108 + ", messageId=" + r117.f361872a + ", resourceType=" + r117.f361875d);
        int r118 = d.f361689a[r107.ordinal()];
        if (r118 != 1) goto L75;
        i(r210, r117, OfficeUrlPreviewOpenSource.COVER);
        return true;
    L75:
        if (r118 != 2) goto L77;
        i(r210, r117, OfficeUrlPreviewOpenSource.EXPAND);
        return true;
    L77:
        if (r118 == 3) goto L84;
        if (r118 == 4) goto L84;
        throw new NoWhenBranchMatchedException();
    L84:
        if (r117.f361877f != OfficeUrlPreviewSourceKind.HTML) goto L86;
        String r119 = r117.f361873b;
    L88:
        if ((!StringsKt.isBlank(r119)) == false) goto L90;
        String r120 = r119;
    L91:
        if (r120 == null) goto L161;
        int r121 = r117.f361875d;
        h2 r122 = h2.f361915a;
        ArtifactBlock r123 = r117.f361876e;
        r122.getClass();
        Integer r124 = h2.j(r123);
        String r125 = r117.f361876e.getTitle();
        Integer r126 = r117.f361876e.getResourceVersion();
        String r127 = r117.f361876e.getArtifactMetaId();
        String r128 = r117.f361874c;
        Integer r129 = h2.f(r117.f361876e);
        String r130 = r117.f361879h.getMessageId();
        String r131 = r117.f361879h.getConversationId();
        String r211 = r117.f361879h.getSectionId();
        String r132 = r117.f361880i;
        Map<String, String> r133 = r117.f361879h.getExt();
        if (r133 == null) goto L95;
        String r212 = r133.get("feishu_record_id");
    L96:
        Map<String, String> r134 = r117.f361879h.getExt();
        if (r134 == null) goto L99;
        String r213 = r134.get("feishu_record_generated_type");
    L100:
        Map<String, String> r135 = r117.f361879h.getExt();
        if (r135 == null) goto L103;
        r104 = r135.get("feishu_record_generated_type");
    L103:
        g(r210, r107, r120, r121, r124, new c(r125, r126, r127, r128, r129, r130, r131, r211, r132, r212, r213, tx9.l.a(r104), com.larus.im.bean.message.a.r(r117.f361879h), com.larus.im.bean.message.a.s(r117.f361879h), r117.f361881j), r117.f361873b, r117.f361877f, r117.f361878g);
        return true;
    L99:
        r213 = null;
        goto L100
    L95:
        r212 = null;
        goto L96
    L161:
        return true;
    L90:
        r120 = null;
        goto L91
    L86:
        r119 = r117.f361874c;
        goto L88
    L50:
        r117 = OfficeUrlPreviewPlatformBridge.f361770c.get(r108);     // Catch: Throwable -> L106
        if (r117 != null) goto L55;
        monitor-exit(r115);
        goto L68
    L55:
        if (r117.f361877f != OfficeUrlPreviewSourceKind.HTML) goto L57;
    L69:
        monitor-exit(r115);
        goto L70
    L57:
        if (r117.f361875d == 14) goto L69;
        if (r116 != null) goto L60;
    L61:
        r103 = true;
    L62:
        if (r103 == true) goto L69;
        if ((!StringsKt.isBlank(r117.f361874c)) == false) goto L69;
        if (Intrinsics.areEqual(r116, r117.f361874c) == true) goto L69;
        monitor-exit(r115);
        goto L68
    L60:
        if (StringsKt.isBlank(r116) == false) goto L62;
    L106:
        th = move-exception;
        throw th;
    L41:
        r114 = false;
        goto L42
    L33:
        if (r112.isEmpty() == false) goto L35;
    L109:
        FLogger.f375446a.w("OfficeUrlPreviewSDK", "[SDK][action_callback_rejected] action=" + r107 + ", previewId=" + r108 + ", reason=invalid_resource_token");
        return true;
    L20:
        th = move-exception;
        Result.Companion r136 = Result.Companion;
        r110 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L147:
        return false;
    L111:
        if (Intrinsics.areEqual(r102, "//flow/office_url_preview_action") == false) goto L147;
        Intent r137 = r310.f267528b;
        if (r137 != null) goto L115;
    L117:
        if (r103 == false) goto L172;
        Action.a r138 = Action.Companion;
        String r139 = n(r310, "action_type");
        r138.getClass();
        Action r140 = Action.a.a(r139);
        if (r140 == null) goto L173;
        String r141 = n(r310, "resource_id");
        if (r141 != null) goto L125;
        return true;
    L125:
        if ((!StringsKt.isBlank(r141)) == false) goto L127;
        String r142 = r141;
    L128:
        if (r142 == null) goto L167;
        Integer r143 = h(r310, "resource_type");
        if (r143 == null) goto L168;
        int r144 = r143.intValue();
        if (f361668b.contains(Integer.valueOf(r144)) == false) goto L174;
        Integer r145 = h(r310, "sub_resource_type");
        String r146 = n(r310, "resource_title");
        Integer r147 = h(r310, "resource_version");
        String r148 = n(r310, "artifact_meta_id");
        h2 r149 = h2.f361915a;
        Integer r150 = Integer.valueOf(r144);
        r149.getClass();
        c r151 = new c(r146, r147, r148, r142, h2.g(r150, r145), n(r310, MusicAppletPage.KEY_MESSAGE_ID), n(r310, "conversation_id"), n(r310, "section_id"), n(r310, "bot_id"), n(r310, "feishu_record_id"), n(r310, "feishu_record_generated_type"), n(r310, "record_scene"), n(r310, "is_general_agent"), n(r310, "chat_id"), n(r310, "previous_page"));
        if (r140 != Action.OPEN) goto L137;
        return true;
    L137:
        if (r140 == Action.EXPAND) goto L175;
        String r152 = n(r310, "original_url");
        if (r144 != 0) goto L142;
        OfficeUrlPreviewSourceKind r153 = OfficeUrlPreviewSourceKind.HTML;
    L146:
        g(r210, r140, r142, r144, r145, r151, r152, r153, r146);
        return true;
    L142:
        if (r144 == 17) goto L144;
        r153 = OfficeUrlPreviewSourceKind.OFFICE;
        goto L146
    L144:
        r153 = OfficeUrlPreviewSourceKind.MARKDOWN;
        goto L146
    L175:
        return true;
    L174:
        return true;
    L168:
        return true;
    L167:
        return true;
    L127:
        r142 = null;
        goto L128
    L173:
        return true;
    L172:
        return true;
    L115:
        if (r137.getBooleanExtra("office_url_preview_internal_action", false) != true) goto L117;
        r103 = true;
        goto L117
    L171:
        return true;
    L156:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void i(Context r100, com.larus.office.card.urlpreview.d r110, OfficeUrlPreviewOpenSource r111) {
        Fragment r101 = e(r100);
        by7.e r102 = null;
        if (r100 != null) goto L9;
        if (r101 == 0) goto L6;
        r100 = r101.getContext();
    L7:
        if (r100 != null) goto L9;
        gd9.i r103 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r103);
        r100 = r103.getApplication();
        goto L9
    L6:
        r100 = null;
    L9:
        Context r104 = r100;
        if (r110.f361877f != OfficeUrlPreviewSourceKind.MARKDOWN) goto L16;
        int r105 = w0.f362041a;
        w0.a(r104, r110.f361876e, r110.f361879h, r101, r110.f361880i, r110.f361873b, r111);
        Set<Integer> r106 = OfficeUrlPreviewMobHelper.f361759a;
        Message r107 = r110.f361879h;
        OfficeUrlPreviewSourceKind r112 = r110.f361877f;
        if ((r101 instanceof by7.e) == false) goto L14;
        r102 = (by7.e) r101;
    L14:
        OfficeUrlPreviewMobHelper.h(r107, r112, r102);
        return;
    L16:
        String r108 = r110.f361873b;
        Result.Companion r109 = Result.Companion;     // Catch: Throwable -> L19
        Object r113 = Result.m9449constructorimpl(UriProtector.parse(r108));     // Catch: Throwable -> L19
    L22:
        if (Result.m9455isFailureimpl(r113) == false) goto L24;
        r113 = null;
    L24:
        Uri r114 = (Uri) r113;
        boolean r115 = false;
        if (r114 != null) goto L28;
    L44:
        if (r115 == true) goto L47;
        return;
    L47:
        if (r110.f361877f == OfficeUrlPreviewSourceKind.OFFICE) goto L53;
        int r116 = n3.f365779a;
        n3.a(r104, r110.f361873b);
        Set<Integer> r117 = OfficeUrlPreviewMobHelper.f361759a;
        Message r118 = r110.f361879h;
        OfficeUrlPreviewSourceKind r119 = r110.f361877f;
        if ((r101 instanceof by7.e) == false) goto L51;
        r102 = (by7.e) r101;
    L51:
        OfficeUrlPreviewMobHelper.h(r118, r119, r102);
        return;
    L53:
        int r120 = w0.f362041a;
        w0.a(r104, r110.f361876e, r110.f361879h, r101, r110.f361880i, r110.f361873b, r111);
        Set<Integer> r121 = OfficeUrlPreviewMobHelper.f361759a;
        OfficeUrlPreviewMobHelper.g(r110.f361879h, r110.f361876e, r110.f361881j);
        return;
    L28:
        if (StringsKt.equals(r114.getScheme(), "http", true) == false) goto L30;
    L33:
        boolean r122 = true;
    L34:
        if (r122 == false) goto L44;
        String r123 = r114.getHost();
        if (r123 != null) goto L38;
    L41:
        boolean r124 = true;
    L42:
        if (r124 == true) goto L44;
        r115 = true;
        goto L44
    L38:
        if (StringsKt.isBlank(r123) == true) goto L41;
        r124 = false;
        goto L42
    L30:
        if (StringsKt.equals(r114.getScheme(), "https", true) == true) goto L33;
        r122 = false;
    L19:
        th = move-exception;
        Result.Companion r125 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void j(Fragment r110, String r111, c r112) {
        Set<Integer> r100 = OfficeUrlPreviewMobHelper.f361759a;
        String r101 = r112.f361677d;
        String r102 = r112.f361676c;
        Integer r103 = r112.f361678e;
        String r104 = r112.f361679f;
        String r105 = r112.f361683j;
        String r106 = r112.f361684k;
        String r107 = r112.f361685l;
        String r113 = r112.f361686m;
        String r114 = r112.f361687n;
        String r115 = r112.f361688o;
        if ((r110 instanceof by7.e) == false) goto L5;
        by7.e r108 = (by7.e) r110;
    L6:
        by7.e r116 = r108;
        Intrinsics.checkNotNullParameter(r111, "buttonName");
        if (CollectionsKt.contains(OfficeUrlPreviewMobHelper.f361759a, r103) == false) goto L34;
        JSONObject r117 = new JSONObject();
        r117.put(MusicAppletPage.KEY_MESSAGE_ID, r104);
        r117.put("feishu_record_id", r105);
        r117.put("feishu_record_generated_type", r106);
        r117.put("record_scene", r107);
        if (Intrinsics.areEqual(r111, "copy_doc") == false) goto L17;
        if (r113 != null) goto L13;
        r113 = "0";
    L13:
        r117.put("is_general_agent", r113);
        if (r114 != null) goto L16;
        r114 = "";
    L16:
        r117.put("chat_id", r114);
    L32:
        tx9.u0.d("message_card", r111, r101, r102, r103, "chat", r115, null, null, null, null, null, r117, r116, 3968);
        return;
    L17:
        boolean r109 = false;
        if (r113 != null) goto L20;
    L23:
        boolean r118 = true;
    L24:
        if (r118 == true) goto L26;
        r117.put("is_general_agent", r113);
    L26:
        if (r114 != null) goto L28;
    L29:
        r109 = true;
    L30:
        if (r109 == true) goto L32;
        r117.put("chat_id", r114);
        goto L32
    L28:
        if (r114.length() != 0) goto L30;
    L20:
        if (r113.length() == 0) goto L23;
        r118 = false;
        goto L24
    L34:
        return;
    L5:
        r108 = null;
        goto L6
    }

    public static final Object d(OfficeUrlPreviewActionInterceptor r100, String r101, Integer r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof OfficeUrlPreviewActionInterceptor$resolveWikiResource$1) == false) goto L7;
        OfficeUrlPreviewActionInterceptor$resolveWikiResource$1 r104 = (OfficeUrlPreviewActionInterceptor$resolveWikiResource$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        int r109 = r104.I$0;
        ResultKt.throwOnFailure(r106);
    L36:
        String r110 = (String) r106;
        if (r110 != null) goto L41;
    L39:
        return null;
    L41:
        return new b(r110, r109, true);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        if (r102 != null) goto L18;
    L20:
        if (r102 != null) goto L23;
    L25:
        if (r102 == null) goto L39;
        if (r102.intValue() != 3) goto L39;
        int r111 = 9;
    L30:
        IFlowOfficeWikiTokenResolver r112 = (IFlowOfficeWikiTokenResolver) ServiceManager.get().getService(IFlowOfficeWikiTokenResolver.class);
        if (r112 == null) goto L39;
        r104.I$0 = r111;
        r104.label = 1;
        Object r113 = r112.a(r101, r104);
        if (r113 == r107) goto L42;
        r109 = r111;
        r106 = r113;
        goto L36
    L42:
        return r107;
    L23:
        if (r102.intValue() != 2) goto L25;
        r111 = 12;
        goto L30
    L18:
        if (r102.intValue() != 1) goto L20;
        r111 = 10;
    L7:
        r104 = new OfficeUrlPreviewActionInterceptor$resolveWikiResource$1(r100, r103);
        goto L8
    }

    public static final Object c(OfficeUrlPreviewActionInterceptor r410, Fragment r411, b r412, c r413, Continuation r414) {
        Fragment r100 = r411;
        r410.getClass();
        if ((r414 instanceof OfficeUrlPreviewActionInterceptor$copyResource$1) == false) goto L7;
        OfficeUrlPreviewActionInterceptor$copyResource$1 r101 = (OfficeUrlPreviewActionInterceptor$copyResource$1) r414;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        c r106 = (c) r101.L$1;
        Fragment r107 = (Fragment) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L37:
        t19.s r108 = t19.s.f544207a;
        Context r109 = r107.requireContext();
        r108.getClass();
        t19.s.o(r109, R.string.larus_text_copied_tip, false);
        k(r106);
        j(r107, "copy_doc", r106);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        c r110 = (c) r101.L$1;
        Fragment r111 = (Fragment) r101.L$0;
        ResultKt.throwOnFailure(r103);
        c r112 = r110;
        r100 = r111;
    L22:
        String r113 = (String) r103;
        if (r113 == null) goto L27;
        gw8.c.f483071a.getClass();
        gw8.c r114 = gw8.c.a.b();
        if (r114 == null) goto L27;
        Context r115 = r100.requireContext();
        int r116 = com.larus.utils.m0.f375450a;
        lw8.l r117 = gw8.c.b.a(r114, r115, com.larus.utils.m0.b(r100.requireContext()), r113, true, new lw8.d(0, null, null, false, null, 0, null, 0.0f, null, 0, 0, null, null, null, null, null, null, null, null, null, null, null, null, null, -1, 31), null, null, 224);
    L28:
        if (r117 != null) goto L30;
        l(r100, Action.COPY);
        return Unit.INSTANCE;
    L30:
        com.larus.bmhome.chat.layout.holder.helper.s0 r118 = ILegacyChatUiServiceDelegate.f297164b.X8();
        if (r118 != null) goto L33;
        l(r100, Action.COPY);
        return Unit.INSTANCE;
    L33:
        Context r119 = r100.requireContext();
        List<? extends lw8.l> r120 = CollectionsKt.listOf(r117);
        r101.L$0 = r100;
        r101.L$1 = r112;
        r101.label = 2;
        if (r118.e(r119, r120, null, r101) == r104) goto L43;
        c r415 = r112;
        r107 = r100;
        r106 = r415;
        goto L37
    L43:
        return r104;
    L27:
        r117 = null;
        goto L28
    L16:
        ResultKt.throwOnFailure(r103);
        if (f361667a.contains(Boxing.boxInt(r412.f361672b)) == true) goto L19;
        l(r100, Action.COPY);
        return Unit.INSTANCE;
    L19:
        CoroutineDispatcher r121 = Dispatchers.getIO();
        OfficeUrlPreviewActionInterceptor$copyResource$content$1 r122 = new OfficeUrlPreviewActionInterceptor$copyResource$content$1(r412, null);
        r101.L$0 = r100;
        r112 = r413;
        r101.L$1 = r112;
        r101.label = 1;
        r103 = BuildersKt.withContext(r121, r122, r101);
        if (r103 != r104) goto L22;
        return r104;
    L7:
        r101 = new OfficeUrlPreviewActionInterceptor$copyResource$1(r410, r414);
        goto L8
    }

    public final void g(Context r210, Action r211, String r212, int r213, Integer r214, c r215, String r216, OfficeUrlPreviewSourceKind r310, String r311) {
        Context r100 = r210;
        String r101 = r216;
        if (r211 != Action.OPEN) goto L5;
        return;
    L5:
        if (r211 != Action.EXPAND) goto L7;
        return;
    L7:
        if (f361668b.contains(Integer.valueOf(r213)) == false) goto L114;
        Action r102 = Action.DOWNLOAD;
        String r103 = "";
        if (r211 != r102) goto L64;
        ActivityResultCaller r104 = e(r210);
        if ((r104 instanceof by7.e) == false) goto L14;
        by7.e r105 = (by7.e) r104;
    L15:
        int r110 = d.f361690b[r310.ordinal()];
        if (r110 != 1) goto L18;
        String r111 = "md";
    L26:
        Set<Integer> r112 = OfficeUrlPreviewMobHelper.f361759a;
        String r113 = r215.f361679f;
        String r114 = r215.f361680g;
        String r115 = r215.f361682i;
        String r116 = r215.f361686m;
        String r106 = r215.f361687n;
        Intrinsics.checkNotNullParameter(new OfficeUrlPreviewMobHelper.a(r113, r114, r115, r116, r106), "metadata");
        Intrinsics.checkNotNullParameter(r111, "contentSecType");
        JSONObject r117 = new JSONObject();
        if (r113 != null) goto L29;
    L34:
        if (r114 != null) goto L36;
    L41:
        if (r115 != null) goto L43;
    L48:
        r117.put("canvas_type", "super_task_file");
        r117.put("content_type", "code");
        r117.put("content_sec_type", r111);
        if (r116 != null) goto L51;
    L55:
        String r118 = "0";
    L56:
        r117.put("is_general_agent", r118);
        r117.put("click_from", "canvas_function");
        if (r106 != null) goto L59;
        r106 = "";
    L59:
        r117.put("chat_id", r106);
        by7.a r107 = new by7.a("general_agent_download");
        if (r105 == null) goto L62;
        r107.f21464b = r105;
    L62:
        r107.f21463a.merge(new TrackParams().merge(r117));
        r107.b();
        goto L64
    L51:
        if ((!StringsKt.isBlank(r116)) == false) goto L53;
        r118 = r116;
    L54:
        if (r118 != null) goto L56;
    L53:
        r118 = null;
        goto L54
    L43:
        if ((!StringsKt.isBlank(r115)) == false) goto L45;
        String r119 = r115;
    L46:
        if (r119 == null) goto L48;
        r117.put("bot_id", r119);
        goto L48
    L45:
        r119 = null;
        goto L46
    L36:
        if ((!StringsKt.isBlank(r114)) == false) goto L38;
        String r120 = r114;
    L39:
        if (r120 == null) goto L41;
        r117.put("conversation_id", r120);
        goto L41
    L38:
        r120 = null;
        goto L39
    L29:
        if ((!StringsKt.isBlank(r113)) == false) goto L31;
        String r121 = r113;
    L32:
        if (r121 == null) goto L34;
        r117.put(MusicAppletPage.KEY_MESSAGE_ID, r121);
        goto L34
    L31:
        r121 = null;
        goto L32
    L18:
        if (r110 != 2) goto L20;
        r111 = "html";
        goto L26
    L20:
        if (r110 == 3) goto L64;
        throw new NoWhenBranchMatchedException();
    L14:
        r105 = null;
    L64:
        if (r310 != OfficeUrlPreviewSourceKind.HTML) goto L78;
        if (r211 != r102) goto L107;
        if (r100 == null) goto L108;
        if (r101 == null) goto L109;
        int r108 = com.larus.office.card.urlpreview.b.f361832a;
        if (r311 == null) goto L72;
        r103 = r311;
    L72:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r103, "fileName");
        IOfficeHtmlFileDownloadService r109 = (IOfficeHtmlFileDownloadService) ServiceManager.get().getService(IOfficeHtmlFileDownloadService.class);
        if (r109 != null) goto L75;
        r109 = new OfficeHtmlFileDownloadServiceNoop();
    L75:
        r109.a(r100, r101, r103);
        return;
    L109:
        return;
    L108:
        return;
    L107:
        return;
    L78:
        if (r310 == OfficeUrlPreviewSourceKind.MARKDOWN) goto L80;
    L95:
        Fragment r122 = e(r210);
        if (r122 != null) goto L98;
        return;
    L98:
        if (r211 == r102) goto L100;
    L105:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r122), null, null, new OfficeUrlPreviewActionInterceptor$handleResourceAction$1(r213, this, r212, r214, r122, r211, r215, null), 3, null);
        return;
    L100:
        if (CollectionsKt.contains(f361667a, r215.f361678e) == false) goto L104;
        IFlowSdkDepend r123 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r123 == null) goto L104;
        r123.D0();
        com.larus.home.impl.sdk.b1.f346144a.c("office_reply_message_doc_download");
    L104:
        j(r122, "download", r215);
        goto L105
    L80:
        if (r211 != Action.COPY) goto L95;
        if (r100 != null) goto L83;
        gd9.i r124 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r124);
        r100 = r124.getApplication();
    L83:
        if (r101 != null) goto L85;
        return;
    L85:
        if ((!StringsKt.isBlank(r216)) == true) goto L88;
        r101 = null;
    L88:
        if (r101 == null) goto L111;
        IFlowSdkDepend r125 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r125 == null) goto L93;
        r125.d0();
        com.larus.home.impl.sdk.i1.f346188a.i(r100, ClipData.newPlainText("link", r101), "bpea-office-markdown-link-copy");
    L93:
        t19.s.f544207a.getClass();
        t19.s.o(r100, R.string.larus_office_markdown_link_copied_toast, false);
        k(r215);
        return;
    L111:
        return;
    }
}
