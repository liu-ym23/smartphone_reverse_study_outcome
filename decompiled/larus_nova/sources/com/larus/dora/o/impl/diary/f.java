package com.larus.dora.o.impl.diary;

import androidx.fragment.app.Fragment;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.larus.xbridge.IXBridgeApi;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final /* synthetic */ int f338512j = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f338513a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f338514b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f338515c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d f338516d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AbsWebFragment f338517e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f338518f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f338519g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ODiaryBetaH5Controller$reportReceiver$1 f338520h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ODiaryBetaH5Controller$feedbackReceiver$1 f338521i;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f338522a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f338523b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f338524c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f338525d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f338526e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f338527f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final boolean f338528g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f338522a, r101.f338522a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f338523b, r101.f338523b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f338524c, r101.f338524c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f338525d, r101.f338525d) == true) goto L21;
            return false;
        L21:
            if (this.f338526e == r101.f338526e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f338527f, r101.f338527f) == true) goto L27;
            return false;
        L27:
            if (this.f338528g == r101.f338528g) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f338522a.hashCode() * 31;
            String r101 = this.f338523b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f338524c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f338525d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (((r107 + r109) * 31) + this.f338526e) * 31;
            String r111 = this.f338527f;
            if (r111 == null) goto L18;
            r102 = r111.hashCode();
        L18:
            int r112 = (r110 + r102) * 31;
            if (this.f338528g == false) goto L21;
            int r113 = 1231;
        L23:
            return r112 + r113;
        L21:
            r113 = 1237;
            goto L23
        L13:
            r109 = r108.hashCode();
            goto L14
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "H5DiaryState(date=" + this.f338522a + ", diaryId=" + this.f338523b + ", lastUpdateTime=" + this.f338524c + ", earliestDate=" + this.f338525d + ", recordDays=" + this.f338526e + ", reason=" + this.f338527f + ", fromDiaryPage=" + this.f338528g + ')';
        }

        public b(String r100, String r101, String r102, String r103, int r104, String r105, boolean r106) {
            Intrinsics.checkNotNullParameter(r100, "date");
            this.f338522a = r100;
            this.f338523b = r101;
            this.f338524c = r102;
            this.f338525d = r103;
            this.f338526e = r104;
            this.f338527f = r105;
            this.f338528g = r106;
        }
    }

    public interface c {
        void a(String r100, int r101, l0 r102);

        void b(b r100);
    }

    public interface d {
        boolean a();

        boolean b();
    }

    static {
    }

    public final void a(String r110, int r111, l0 r112) {
        if (r112 == null) goto L5;
        int r100 = r112.f338558a;
    L7:
        if (r112 == null) goto L15;
        String r113 = r112.f338559b;
        if (r113 == null) goto L15;
        if ((!StringsKt.isBlank(r113)) == true) goto L14;
        r113 = null;
    L14:
        if (r113 == null) goto L15;
    L16:
        FLogger.f375446a.i("ODiaryBetaH5", "notify h5 feedback submitted diary=" + r110 + " action=" + r111 + " target=" + r100 + '/' + r113);
        AbsWebFragment r101 = this.f338517e;
        if (r101 == null) goto L19;
        JSONObject r102 = new JSONObject();
        r102.put("diary_id", r110);
        r102.put("action_type", r111);
        r102.put("target_type", r100);
        r102.put("target_id", r113);
        Unit r114 = Unit.INSTANCE;
        r101.T90("dora.diary.feedbackSubmitted", r102);
    L19:
        IXBridgeApi.f379669a.b("dora.diary.feedbackSubmitted", MapsKt.mapOf(new Pair[]{TuplesKt.to("diary_id", r110), TuplesKt.to("action_type", Integer.valueOf(r111)), TuplesKt.to("target_type", Integer.valueOf(r100)), TuplesKt.to("target_id", r113)}), null);
        return;
    L15:
        r113 = r110;
        goto L16
    L5:
        r100 = 1;
        goto L7
    }

    public f(Fragment r100, String r101, ODiaryContentFragment.b r102, ODiaryContentFragment.c r103) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "url");
        Intrinsics.checkNotNullParameter(r102, "eventListener");
        Intrinsics.checkNotNullParameter(r103, "hostState");
        this.f338513a = r100;
        this.f338514b = r101;
        this.f338515c = r102;
        this.f338516d = r103;
        this.f338520h = new ODiaryBetaH5Controller$reportReceiver$1(this);
        this.f338521i = new ODiaryBetaH5Controller$feedbackReceiver$1(this);
    }
}
