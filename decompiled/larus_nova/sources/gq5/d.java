package gq5;

import com.bytedance.android.livesdkapi.monitor.ILiveHybridMonitor;
import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f482186a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482188b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f482189c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482190d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f482191e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f482192f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f482193g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f482194h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f482187a, r101.f482187a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482188b, r101.f482188b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482189c, r101.f482189c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482190d, r101.f482190d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482191e, r101.f482191e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482192f, r101.f482192f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482193g, r101.f482193g) == true) goto L30;
            return false;
        L30:
            if (this.f482194h == r101.f482194h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f482187a.hashCode() * 31;
            String r101 = this.f482188b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f482189c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f482190d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            Boolean r111 = this.f482191e;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            String r114 = this.f482192f;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f482193g;
            if (r117 == null) goto L26;
            r102 = r117.hashCode();
        L26:
            int r118 = (r116 + r102) * 31;
            if (this.f482194h == false) goto L29;
            int r119 = 1231;
        L31:
            return r118 + r119;
        L29:
            r119 = 1237;
            goto L31
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "ReportSpaceDocsMoreClickBean(click=" + this.f482187a + ", target=" + this.f482188b + ", containerId=" + this.f482189c + ", pageToken=" + this.f482190d + ", isShortcut=" + this.f482191e + ", fileId=" + this.f482192f + ", fileType=" + this.f482193g + ", isOriginExternal=" + this.f482194h + ')';
        }

        public a(String r100, String r101, String r102, String r103, Boolean r104, String r105, String r106, boolean r107) {
            Intrinsics.checkNotNullParameter(r100, "click");
            this.f482187a = r100;
            this.f482188b = r101;
            this.f482189c = r102;
            this.f482190d = r103;
            this.f482191e = r104;
            this.f482192f = r105;
            this.f482193g = r106;
            this.f482194h = r107;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482195a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482196b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f482197c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482198d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482199e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f482200f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f482201g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f482202h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f482203i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Boolean f482204j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f482195a, r101.f482195a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482196b, r101.f482196b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482197c, r101.f482197c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482198d, r101.f482198d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482199e, r101.f482199e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482200f, r101.f482200f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482201g, r101.f482201g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f482202h, r101.f482202h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f482203i, r101.f482203i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f482204j, r101.f482204j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f482195a.hashCode() * 31;
            String r101 = this.f482196b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.f482197c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f482198d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f482199e;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Boolean r114 = this.f482200f;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f482201g;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f482202h;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            String r123 = this.f482203i;
            if (r123 != null) goto L33;
            int r124 = 0;
        L34:
            int r125 = (r122 + r124) * 31;
            Boolean r126 = this.f482204j;
            if (r126 == null) goto L39;
            r102 = r126.hashCode();
        L39:
            return r125 + r102;
        L33:
            r124 = r123.hashCode();
            goto L34
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "ReportWikiDelClickBean(click=" + this.f482195a + ", target=" + this.f482196b + ", isFavorites=" + this.f482197c + ", containerId=" + this.f482198d + ", pageToken=" + this.f482199e + ", isShortcut=" + this.f482200f + ", fileId=" + this.f482201g + ", fileType=" + this.f482202h + ", deleteScope=" + this.f482203i + ", isIncludeChildrenPage=" + this.f482204j + ')';
        }

        public b(String r100, String r101, Boolean r102, String r103, String r104, Boolean r105, String r106, String r107, String r110, Boolean r111) {
            Intrinsics.checkNotNullParameter(r100, "click");
            this.f482195a = r100;
            this.f482196b = r101;
            this.f482197c = r102;
            this.f482198d = r103;
            this.f482199e = r104;
            this.f482200f = r105;
            this.f482201g = r106;
            this.f482202h = r107;
            this.f482203i = r110;
            this.f482204j = r111;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f482207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482208d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482209e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f482210f;

        public c() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f482205a, r101.f482205a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482206b, r101.f482206b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482207c, r101.f482207c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482208d, r101.f482208d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482209e, r101.f482209e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482210f, r101.f482210f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f482205a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f482206b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.f482207c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f482208d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f482209e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Boolean r116 = this.f482210f;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
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
            return "ReportWikiDeleteConfirmBean(containerId=" + this.f482205a + ", pageToken=" + this.f482206b + ", isShortcut=" + this.f482207c + ", fileId=" + this.f482208d + ", fileType=" + this.f482209e + ", isIncludeChildrenPage=" + this.f482210f + ')';
        }

        public c(String r100, String r101, Boolean r102, String r103, String r104, Boolean r105) {
            this.f482205a = r100;
            this.f482206b = r101;
            this.f482207c = r102;
            this.f482208d = r103;
            this.f482209e = r104;
            this.f482210f = r105;
        }
    }

    /* JADX INFO: renamed from: gq5.d$d, reason: collision with other inner class name */
    public static final class C6055d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482211a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482212b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f482213c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482214d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482215e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f482216f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f482217g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f482218h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f482219i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f482220j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f482221k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f482222l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final String f482223m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final String f482224n;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6055d) == true) goto L8;
            return false;
        L8:
            C6055d r101 = (C6055d) r100;
            if (Intrinsics.areEqual(this.f482211a, r101.f482211a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482212b, r101.f482212b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482213c, r101.f482213c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482214d, r101.f482214d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482215e, r101.f482215e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482216f, r101.f482216f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482217g, r101.f482217g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f482218h, r101.f482218h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f482219i, r101.f482219i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f482220j, r101.f482220j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f482221k, r101.f482221k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f482222l, r101.f482222l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.f482223m, r101.f482223m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.f482224n, r101.f482224n) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f482211a.hashCode() * 31;
            String r101 = this.f482212b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f482213c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f482214d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f482215e;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            String r114 = this.f482216f;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f482217g;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f482218h;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            String r123 = this.f482219i;
            if (r123 != null) goto L33;
            int r124 = 0;
        L34:
            int r125 = (r122 + r124) * 31;
            String r126 = this.f482220j;
            if (r126 != null) goto L37;
            int r127 = 0;
        L38:
            int r128 = (r125 + r127) * 31;
            String r129 = this.f482221k;
            if (r129 != null) goto L41;
            int r130 = 0;
        L42:
            int r131 = (r128 + r130) * 31;
            String r132 = this.f482222l;
            if (r132 != null) goto L45;
            int r133 = 0;
        L46:
            int r134 = (r131 + r133) * 31;
            String r135 = this.f482223m;
            if (r135 != null) goto L49;
            int r136 = 0;
        L50:
            int r137 = (r134 + r136) * 31;
            String r138 = this.f482224n;
            if (r138 == null) goto L55;
            r102 = r138.hashCode();
        L55:
            return r137 + r102;
        L49:
            r136 = r135.hashCode();
            goto L50
        L45:
            r133 = r132.hashCode();
            goto L46
        L41:
            r130 = r129.hashCode();
            goto L42
        L37:
            r127 = r126.hashCode();
            goto L38
        L33:
            r124 = r123.hashCode();
            goto L34
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "ReportWikiLocSelectClickBean(click=" + this.f482211a + ", target=" + this.f482212b + ", viewTitle=" + this.f482213c + ", targetSpaceId=" + this.f482214d + ", containerId=" + this.f482215e + ", pageToken=" + this.f482216f + ", childrenFileType=" + this.f482217g + ", childrenFileId=" + this.f482218h + ", childrenPageToken=" + this.f482219i + ", triggerLocation=" + this.f482220j + ", targetLocation=" + this.f482221k + ", targetFolderType=" + this.f482222l + ", originalModule=" + this.f482223m + ", targetModule=" + this.f482224n + ')';
        }

        public C6055d(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r110, String r111, String r112, String r113, String r114) {
            Intrinsics.checkNotNullParameter("confirm", "click");
            this.f482211a = "confirm";
            this.f482212b = "ccm_docs_page_view";
            this.f482213c = r100;
            this.f482214d = r101;
            this.f482215e = r102;
            this.f482216f = r103;
            this.f482217g = r104;
            this.f482218h = r105;
            this.f482219i = r106;
            this.f482220j = r110;
            this.f482221k = r111;
            this.f482222l = r112;
            this.f482223m = r113;
            this.f482224n = r114;
        }
    }

    public static final class e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f482227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482229e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f482230f;

        public e() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f482225a, r101.f482225a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482226b, r101.f482226b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482227c, r101.f482227c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482228d, r101.f482228d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482229e, r101.f482229e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482230f, r101.f482230f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f482225a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f482226b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.f482227c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f482228d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f482229e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            Boolean r116 = this.f482230f;
            if (r116 == null) goto L27;
            r101 = r116.hashCode();
        L27:
            return r115 + r101;
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
            return "ReportWikiTreeAddBean(containerId=" + this.f482225a + ", pageToken=" + this.f482226b + ", isShortcut=" + this.f482227c + ", fileId=" + this.f482228d + ", fileType=" + this.f482229e + ", isSelfWiki=" + this.f482230f + ')';
        }

        public e(String r100, String r101, Boolean r102, String r103, String r104, Boolean r105) {
            this.f482225a = r100;
            this.f482226b = r101;
            this.f482227c = r102;
            this.f482228d = r103;
            this.f482229e = r104;
            this.f482230f = r105;
        }
    }

    public static final class f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482231a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482232b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f482233c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482234d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Boolean f482235e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f482236f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f482237g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Boolean f482238h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f482239i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final String f482240j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Boolean f482241k;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f482231a, r101.f482231a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482232b, r101.f482232b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482233c, r101.f482233c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482234d, r101.f482234d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482235e, r101.f482235e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482236f, r101.f482236f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482237g, r101.f482237g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f482238h, r101.f482238h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f482239i, r101.f482239i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f482240j, r101.f482240j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f482241k, r101.f482241k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.f482231a.hashCode() * 31) + this.f482232b.hashCode()) * 31) + this.f482233c.hashCode()) * 31;
            String r101 = this.f482234d;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.f482235e;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f482236f;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f482237g;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Boolean r114 = this.f482238h;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f482239i;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f482240j;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            Boolean r123 = this.f482241k;
            if (r123 == null) goto L35;
            r102 = r123.hashCode();
        L35:
            return r122 + r102;
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "ReportWikiTreeAddClickBean(click=" + this.f482231a + ", target=" + this.f482232b + ", triggerLocation=" + this.f482233c + ", childrenFileType=" + this.f482234d + ", isFavorites=" + this.f482235e + ", containerId=" + this.f482236f + ", pageToken=" + this.f482237g + ", isShortcut=" + this.f482238h + ", fileId=" + this.f482239i + ", fileType=" + this.f482240j + ", isSelfWiki=" + this.f482241k + ')';
        }

        public f(String r100, String r101, String r102, String r103, Boolean r104, String r105, String r106, Boolean r107, String r110, String r111, Boolean r112) {
            Intrinsics.checkNotNullParameter(r100, "click");
            Intrinsics.checkNotNullParameter(r101, PickerReporterConstants.KEY.TARGET);
            Intrinsics.checkNotNullParameter(r102, "triggerLocation");
            this.f482231a = r100;
            this.f482232b = r101;
            this.f482233c = r102;
            this.f482234d = r103;
            this.f482235e = r104;
            this.f482236f = r105;
            this.f482237g = r106;
            this.f482238h = r107;
            this.f482239i = r110;
            this.f482240j = r111;
            this.f482241k = r112;
        }
    }

    public static final class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482242a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482243b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f482244c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482245d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482246e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f482247f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f482248g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f482249h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final Integer f482250i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Boolean f482251j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final Boolean f482252k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f482253l;

        public g(Boolean r100, String r101) {
            Intrinsics.checkNotNullParameter("slide", "click");
            this("slide", r100, r101, 4080);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f482242a, r101.f482242a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482243b, r101.f482243b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482244c, r101.f482244c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482245d, r101.f482245d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482246e, r101.f482246e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482247f, r101.f482247f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482248g, r101.f482248g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f482249h, r101.f482249h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f482250i, r101.f482250i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f482251j, r101.f482251j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.f482252k, r101.f482252k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.f482253l, r101.f482253l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f482242a.hashCode() * 31;
            String r101 = this.f482243b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.f482244c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f482245d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f482246e;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Boolean r114 = this.f482247f;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f482248g;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f482249h;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            Integer r123 = this.f482250i;
            if (r123 != null) goto L33;
            int r124 = 0;
        L34:
            int r125 = (r122 + r124) * 31;
            Boolean r126 = this.f482251j;
            if (r126 != null) goto L37;
            int r127 = 0;
        L38:
            int r128 = (r125 + r127) * 31;
            Boolean r129 = this.f482252k;
            if (r129 == null) goto L43;
            r102 = r129.hashCode();
        L43:
            return ((r128 + r102) * 31) + this.f482253l.hashCode();
        L37:
            r127 = r126.hashCode();
            goto L38
        L33:
            r124 = r123.hashCode();
            goto L34
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "ReportWikiTreeClickBean(click=" + this.f482242a + ", target=" + this.f482243b + ", isFavorites=" + this.f482244c + ", containerId=" + this.f482245d + ", pageToken=" + this.f482246e + ", isShortcut=" + this.f482247f + ", fileId=" + this.f482248g + ", fileType=" + this.f482249h + ", isFromShareLink=" + this.f482250i + ", isSelfWiki=" + this.f482251j + ", isFirstNode=" + this.f482252k + ", location=" + this.f482253l + ')';
        }

        public /* synthetic */ g(String r110, Boolean r111, String r112, int r210) {
            String r100 = null;
            if ((r210 & 2) == 0) goto L5;
            String r101 = null;
        L7:
            if ((r210 & 4) == 0) goto L9;
            Boolean r102 = null;
        L11:
            if ((r210 & 8) == 0) goto L13;
            String r103 = null;
        L15:
            if ((r210 & 2048) == 0) goto L17;
            r100 = "wiki";
        L17:
            this(r110, r101, r102, r103, null, null, null, null, null, null, null, r100);
            return;
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = "none";
            goto L7
        }

        public g(String r100, String r101, Boolean r102, String r103, String r104, Boolean r105, String r106, String r107, Integer r110, Boolean r111, Boolean r112, String r113) {
            Intrinsics.checkNotNullParameter(r100, "click");
            Intrinsics.checkNotNullParameter(r113, "location");
            this.f482242a = r100;
            this.f482243b = r101;
            this.f482244c = r102;
            this.f482245d = r103;
            this.f482246e = r104;
            this.f482247f = r105;
            this.f482248g = r106;
            this.f482249h = r107;
            this.f482250i = r110;
            this.f482251j = r111;
            this.f482252k = r112;
            this.f482253l = r113;
        }
    }

    public static final class h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482254a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482255b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f482256c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482257d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482258e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f482259f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final Boolean f482260g;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f482254a, r101.f482254a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482255b, r101.f482255b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482256c, r101.f482256c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482257d, r101.f482257d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482258e, r101.f482258e) == true) goto L24;
            return false;
        L24:
            if (this.f482259f == r101.f482259f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482260g, r101.f482260g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f482254a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f482255b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Boolean r107 = this.f482256c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f482257d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f482258e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            if (this.f482259f == false) goto L25;
            int r116 = 1231;
        L26:
            int r117 = (r115 + r116) * 31;
            Boolean r118 = this.f482260g;
            if (r118 == null) goto L31;
            r101 = r118.hashCode();
        L31:
            return r117 + r101;
        L25:
            r116 = 1237;
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
            return "ReportWikiTreeMoreBean(containerId=" + this.f482254a + ", pageToken=" + this.f482255b + ", isShortcut=" + this.f482256c + ", fileId=" + this.f482257d + ", fileType=" + this.f482258e + ", isOriginExternal=" + this.f482259f + ", isSelfwiki=" + this.f482260g + ')';
        }

        public h(String r100, String r101, Boolean r102, String r103, String r104, boolean r105, Boolean r106) {
            this.f482254a = r100;
            this.f482255b = r101;
            this.f482256c = r102;
            this.f482257d = r103;
            this.f482258e = r104;
            this.f482259f = r105;
            this.f482260g = r106;
        }
    }

    public static final class i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f482261a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f482262b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f482263c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f482264d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f482265e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Boolean f482266f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f482267g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f482268h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final boolean f482269i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final Boolean f482270j;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f482261a, r101.f482261a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f482262b, r101.f482262b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f482263c, r101.f482263c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f482264d, r101.f482264d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f482265e, r101.f482265e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f482266f, r101.f482266f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f482267g, r101.f482267g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f482268h, r101.f482268h) == true) goto L33;
            return false;
        L33:
            if (this.f482269i == r101.f482269i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.f482270j, r101.f482270j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f482261a.hashCode() * 31;
            String r101 = this.f482262b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            Boolean r105 = this.f482263c;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f482264d;
            if (r108 != null) goto L13;
            int r109 = 0;
        L14:
            int r110 = (r107 + r109) * 31;
            String r111 = this.f482265e;
            if (r111 != null) goto L17;
            int r112 = 0;
        L18:
            int r113 = (r110 + r112) * 31;
            Boolean r114 = this.f482266f;
            if (r114 != null) goto L21;
            int r115 = 0;
        L22:
            int r116 = (r113 + r115) * 31;
            String r117 = this.f482267g;
            if (r117 != null) goto L25;
            int r118 = 0;
        L26:
            int r119 = (r116 + r118) * 31;
            String r120 = this.f482268h;
            if (r120 != null) goto L29;
            int r121 = 0;
        L30:
            int r122 = (r119 + r121) * 31;
            if (this.f482269i == false) goto L33;
            int r123 = 1231;
        L34:
            int r124 = (r122 + r123) * 31;
            Boolean r125 = this.f482270j;
            if (r125 == null) goto L39;
            r102 = r125.hashCode();
        L39:
            return r124 + r102;
        L33:
            r123 = 1237;
            goto L34
        L29:
            r121 = r120.hashCode();
            goto L30
        L25:
            r118 = r117.hashCode();
            goto L26
        L21:
            r115 = r114.hashCode();
            goto L22
        L17:
            r112 = r111.hashCode();
            goto L18
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
            return "ReportWikiTreeMoreClickBean(click=" + this.f482261a + ", target=" + this.f482262b + ", isFavorites=" + this.f482263c + ", containerId=" + this.f482264d + ", pageToken=" + this.f482265e + ", isShortcut=" + this.f482266f + ", fileId=" + this.f482267g + ", fileType=" + this.f482268h + ", isOriginExternal=" + this.f482269i + ", isSelfWiki=" + this.f482270j + ')';
        }

        public i(String r100, String r101, Boolean r102, String r103, String r104, Boolean r105, String r106, String r107, boolean r110, Boolean r111) {
            Intrinsics.checkNotNullParameter(r100, "click");
            this.f482261a = r100;
            this.f482262b = r101;
            this.f482263c = r102;
            this.f482264d = r103;
            this.f482265e = r104;
            this.f482266f = r105;
            this.f482267g = r106;
            this.f482268h = r107;
            this.f482269i = r110;
            this.f482270j = r111;
        }
    }

    public static final class j {
        static {
        }

        @JvmStatic
        public static final String a(int r100) {
            SelectIndex.Companion.getClass();
            SelectIndex r101 = SelectIndex.a.a(r100);
            int r102 = r101.getDocumentType();
            if (r102 != 2) goto L5;
            return "doc";
        L5:
            if (r102 != 3) goto L7;
            return DocumentType.SHEET_NAME;
        L7:
            if (r102 == 8) goto L25;
            if (r102 != 22) goto L11;
            return DocumentType.DOCX_NAME;
        L11:
            if (r102 != 111) goto L13;
            return DocumentType.WIKI_FOLDER_NAME;
        L13:
            if (r102 != 11) goto L15;
            return DocumentType.MINDNOTE_NAME;
        L15:
            if (r102 == 12) goto L18;
            return "";
        L18:
            if (r101 != SelectIndex.MEDIA) goto L20;
            return "upload_picture";
        L20:
            return "upload_file";
        L25:
            if (r101 != SelectIndex.SURVEY) goto L27;
            return "new_form_templates";
        L27:
            return DocumentType.BITABLE_NAME;
        }

        @JvmStatic
        public static final String b(int r100, int r101) {
            boolean r102 = true;
            if (r100 != 1) goto L5;
            SelectIndex.Companion.getClass();
            if (r101 != SelectIndex.MEDIA.ordinal()) goto L17;
        L20:
            if (r102 == false) goto L22;
            return "upload_file_to";
        L22:
            return "create_file";
        L17:
            if (r101 == SelectIndex.FILE.ordinal()) goto L20;
            r102 = false;
            goto L20
        L5:
            if (r100 != 2) goto L7;
            return "move_to";
        L7:
            if (r100 != 3) goto L9;
            return "shortcut_to";
        L9:
            if (r100 == 4) goto L11;
            return "";
        L11:
            return "make_a_copy_to";
        }
    }

    static {
    }

    public d() {
    }

    @JvmStatic
    public static final void d(a r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        JSONObject r100 = new JSONObject();
        gq5.e.b(r100, "click", r110.f482187a);
        gq5.e.b(r100, PickerReporterConstants.KEY.TARGET, r110.f482188b);
        if (r110.f482194h == false) goto L5;
        String r101 = "space";
    L6:
        r100.put("original_docs_container", r101);
        if (Intrinsics.areEqual(r110.f482191e, Boolean.TRUE) == false) goto L9;
        String r102 = "true";
    L10:
        r100.put("is_shortcut", r102);
        a(r100, r110.f482189c, r110.f482190d, r110.f482191e, r110.f482192f, r110.f482193g, null, null, 96);
        gq5.e.c("ccm_space_docs_more_menu_click", r100);
        return;
    L9:
        r102 = "false";
        goto L10
    L5:
        r101 = "wiki";
        goto L6
    }

    @JvmStatic
    public static final void g(Boolean r110) {
        JSONObject r100 = new JSONObject();
        if (r110 == null) goto L5;
        String r111 = r110.toString();
    L6:
        gq5.e.b(r100, "is_category_show", r111);
        a(r100, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_all_space_view", r100);
        return;
    L5:
        r111 = null;
        goto L6
    }

    @JvmStatic
    public static final void h(b r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        JSONObject r100 = new JSONObject();
        gq5.e.b(r100, "click", r110.f482195a);
        gq5.e.b(r100, PickerReporterConstants.KEY.TARGET, r110.f482196b);
        gq5.e.b(r100, "is_success", Boolean.TRUE);
        Boolean r101 = r110.f482197c;
        String r102 = null;
        if (r101 == null) goto L5;
        String r103 = r101.toString();
    L6:
        gq5.e.b(r100, "is_favorites", r103);
        gq5.e.b(r100, "delete_scope", r110.f482203i);
        Boolean r104 = r110.f482204j;
        if (r104 == null) goto L9;
        r102 = r104.toString();
    L9:
        gq5.e.b(r100, "is_include_children_page", r102);
        a(r100, r110.f482198d, r110.f482199e, r110.f482200f, r110.f482201g, r110.f482202h, null, null, 96);
        gq5.e.c("ccm_wiki_delete_confirm_click", r100);
        return;
    L5:
        r103 = null;
        goto L6
    }

    @JvmStatic
    public static final void i(C6055d r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        JSONObject r100 = new JSONObject();
        gq5.e.b(r100, "click", r110.f482211a);
        gq5.e.b(r100, PickerReporterConstants.KEY.TARGET, r110.f482212b);
        gq5.e.b(r100, "view_title", r110.f482213c);
        gq5.e.b(r100, "target_space_id", gq5.e.a(r110.f482214d));
        gq5.e.b(r100, "children_file_type", r110.f482217g);
        gq5.e.b(r100, "trigger_location", r110.f482220j);
        gq5.e.b(r100, "target_folder_type", r110.f482222l);
        gq5.e.b(r100, "target_location", r110.f482221k);
        gq5.e.b(r100, "children_file_id", gq5.e.a(r110.f482218h));
        gq5.e.b(r100, "children_page_token", gq5.e.a(r110.f482219i));
        gq5.e.b(r100, "original_module", r110.f482223m);
        gq5.e.b(r100, "target_module", r110.f482224n);
        a(r100, r110.f482215e, r110.f482216f, null, null, null, null, null, 124);
        gq5.e.c("ccm_wiki_file_location_select_click", r100);
    }

    @JvmStatic
    public static final void m(String r110) {
        JSONObject r100 = new JSONObject();
        gq5.e.b(r100, "view_title", "move_to");
        a(r100, r110, null, null, null, null, null, null, 126);
        gq5.e.c("ccm_wiki_permission_change_view", r100);
    }

    @JvmStatic
    public static final void n(g r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        JSONObject r100 = new JSONObject();
        gq5.e.b(r100, "click", r110.f482242a);
        gq5.e.b(r100, PickerReporterConstants.KEY.TARGET, r110.f482243b);
        Boolean r101 = r110.f482244c;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        gq5.e.b(r100, "is_favorites", r102);
        Integer r103 = r110.f482250i;
        if (r103 != null) goto L10;
    L12:
        gq5.e.b(r100, "is_first_node", String.valueOf(r110.f482252k));
        gq5.e.b(r100, "trigger_location", r110.f482253l);
        a(r100, r110.f482245d, r110.f482246e, r110.f482247f, r110.f482248g, r110.f482249h, null, r110.f482251j, 32);
        gq5.e.c("ccm_wiki_tree_click", r100);
        return;
    L10:
        if (r103.intValue() != 1) goto L12;
        gq5.e.b(r100, "is_from_share_link", "true");
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void o(i r110) {
        Intrinsics.checkNotNullParameter(r110, "bean");
        JSONObject r100 = new JSONObject();
        gq5.e.b(r100, "click", r110.f482261a);
        gq5.e.b(r100, PickerReporterConstants.KEY.TARGET, r110.f482262b);
        Boolean r101 = r110.f482263c;
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        gq5.e.b(r100, "is_favorites", r102);
        if (r110.f482269i == false) goto L9;
        String r103 = "space";
    L10:
        r100.put("original_docs_container", r103);
        a(r100, r110.f482264d, r110.f482265e, r110.f482266f, r110.f482267g, r110.f482268h, null, r110.f482270j, 32);
        gq5.e.c("ccm_wiki_tree_more_click", r100);
        return;
    L9:
        r103 = "wiki";
        goto L10
    L5:
        r102 = null;
        goto L6
    }

    @JvmStatic
    public static final void j(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "view_title");
        JSONObject r112 = new JSONObject();
        gq5.e.b(r112, "view_title", r110);
        a(r112, r111, null, null, null, null, null, null, 126);
        gq5.e.c("ccm_wiki_file_location_select_view", r112);
    }

    @JvmStatic
    public static final void k(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "click");
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        JSONObject r112 = new JSONObject();
        gq5.e.b(r112, "click", r110);
        gq5.e.b(r112, PickerReporterConstants.KEY.TARGET, r111);
        a(r112, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_home_click", r112);
    }

    @JvmStatic
    public static final void l(String r110, String r111) {
        Intrinsics.checkNotNullParameter(r110, "click");
        Intrinsics.checkNotNullParameter("none", PickerReporterConstants.KEY.TARGET);
        JSONObject r112 = new JSONObject();
        gq5.e.b(r112, "view_title", "move_to");
        gq5.e.b(r112, "click", r110);
        gq5.e.b(r112, PickerReporterConstants.KEY.TARGET, "none");
        gq5.e.b(r112, "is_success", "true");
        a(r112, r111, null, null, null, null, null, null, 126);
        gq5.e.c("ccm_wiki_permission_change_click", r112);
    }

    @JvmStatic
    public static final void b(String r110, String r111, String r112, String r113) {
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        JSONObject r114 = new JSONObject();
        r114.put("click", "docs_view");
        r114.put("view_title", "shortcut_to");
        a(r114, r110, r111, Boolean.TRUE, r112, r113, null, null, 96);
        r100.u("ccm_wiki_docs_move_result_toast_click", r114);
    }

    @JvmStatic
    public static final void c(String r110, String r111, String r112, String r113) {
        com.bytedance.ee.bear.contract.d r100 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        JSONObject r114 = new JSONObject();
        r114.put("is_success", "true");
        r114.put("view_title", "shortcut_to");
        a(r114, r110, r111, Boolean.TRUE, r112, r113, null, null, 96);
        r100.u("ccm_wiki_docs_move_result_toast_view", r114);
    }

    @JvmStatic
    public static final void e(String r110, String r111, Boolean r112, String r113) {
        Intrinsics.checkNotNullParameter(r110, "click");
        Intrinsics.checkNotNullParameter(r111, PickerReporterConstants.KEY.TARGET);
        JSONObject r114 = new JSONObject();
        gq5.e.b(r114, "click", r110);
        gq5.e.b(r114, PickerReporterConstants.KEY.TARGET, r111);
        if (r112 == null) goto L5;
        String r115 = r112.toString();
    L6:
        gq5.e.b(r114, "is_category_show", r115);
        gq5.e.b(r114, "category_id", r113);
        a(r114, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_all_space_click", r114);
        return;
    L5:
        r115 = null;
        goto L6
    }

    public static /* synthetic */ void f(String r100, String r101, Boolean r102, int r103) {
        if ((r103 & 4) == 0) goto L5;
        r102 = null;
    L5:
        e(r100, r101, r102, null);
    }

    public static void p(String r110, String r111, Integer r112, boolean r113, int r114) {
        if ((r114 & 1) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        String r101 = null;
    L11:
        if ((r114 & 4) == 0) goto L14;
        r112 = null;
    L14:
        if ((r114 & 8) == 0) goto L16;
        r113 = false;
    L16:
        JSONObject r115 = new JSONObject();
        a(r115, r100, r101, null, null, null, null, Boolean.valueOf(r113), 60);
        if (r112 != null) goto L20;
    L22:
        gq5.e.c("ccm_wiki_tree_view", r115);
        return;
    L20:
        if (r112.intValue() != 1) goto L22;
        gq5.e.b(r115, "is_from_share_link", "true");
        goto L22
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }

    public static void a(JSONObject r100, String r101, String r102, Boolean r103, String r104, String r105, String r106, Boolean r110, int r111) {
        String r107 = null;
        if ((r111 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r111 & 2) == 0) goto L9;
        r102 = null;
    L9:
        if ((r111 & 4) == 0) goto L12;
        r103 = null;
    L12:
        if ((r111 & 8) == 0) goto L15;
        r104 = null;
    L15:
        if ((r111 & 16) == 0) goto L18;
        r105 = null;
    L18:
        if ((r111 & 32) == 0) goto L21;
        r106 = "wiki";
    L21:
        if ((r111 & 64) == 0) goto L23;
        r110 = null;
    L23:
        gq5.e.b(r100, "container_id", gq5.e.a(r101));
        gq5.e.b(r100, ILiveHybridMonitor.BusinessParams.CONTAINER_TYPE, "wiki");
        gq5.e.b(r100, "page_token", gq5.e.a(r102));
        if (r103 == null) goto L26;
        String r108 = r103.toString();
    L27:
        gq5.e.b(r100, "is_shortcut", r108);
        if (Intrinsics.areEqual(r103, Boolean.TRUE) == false) goto L30;
        String r109 = gq5.e.a(r102);
    L31:
        gq5.e.b(r100, "shortcut_id", r109);
        if (r110 == null) goto L34;
        r107 = r110.toString();
    L34:
        gq5.e.b(r100, "is_self_wiki", r107);
        gq5.e.b(r100, "file_id", gq5.e.a(r104));
        gq5.e.b(r100, "file_type", r105);
        gq5.e.b(r100, "app_form", "null");
        gq5.e.b(r100, EventConstant.Key.MODULE, r106);
        gq5.e.b(r100, "sub_module", "null");
        if (qc5.a.h() == false) goto L37;
        String r112 = "new_format";
    L38:
        gq5.e.b(r100, "space_version", r112);
        return;
    L37:
        r112 = "original";
        goto L38
    L30:
        r109 = null;
        goto L31
    L26:
        r108 = null;
        goto L27
    }
}
