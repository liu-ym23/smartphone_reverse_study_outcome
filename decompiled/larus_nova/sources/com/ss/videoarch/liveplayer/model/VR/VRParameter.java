package com.ss.videoarch.liveplayer.model.VR;

import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final class VRParameter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f459516a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f459517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f459518c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f459519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f459520e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f459521f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f459522g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f459523h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f459524i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f459525j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f459526k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f459527l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f459528m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public float f459529n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f459530o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f459531p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f459532q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public float f459533r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f459534s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public float f459535t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public float f459536u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public float f459537v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public float f459538w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public float f459539x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f459540y;

    public static final enum DOF extends Enum<DOF> {
        public static final DOF SIX_DOF = null;
        public static final DOF THREE_DOF = null;
        public static final DOF UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DOF[] f459541a = null;

        static {
            DOF r100 = new DOF("UNKNOWN", 0);
            UNKNOWN = r100;
            DOF r101 = new DOF("THREE_DOF", 1);
            THREE_DOF = r101;
            DOF r102 = new DOF("SIX_DOF", 2);
            SIX_DOF = r102;
            f459541a = new DOF[]{r100, r101, r102};
        }

        public static DOF[] values() {
            return (DOF[]) f459541a.clone();
        }

        public static DOF valueOf(String r100) {
            return (DOF) a.a(DOF.class, r100);
        }

        private DOF(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Dimensional extends Enum<Dimensional> {
        public static final Dimensional THREE_DIMENSIONAL = null;
        public static final Dimensional TWO_DIMENSIONAL = null;
        public static final Dimensional UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Dimensional[] f459542a = null;

        static {
            Dimensional r100 = new Dimensional("UNKNOWN", 0);
            UNKNOWN = r100;
            Dimensional r101 = new Dimensional("TWO_DIMENSIONAL", 1);
            TWO_DIMENSIONAL = r101;
            Dimensional r102 = new Dimensional("THREE_DIMENSIONAL", 2);
            THREE_DIMENSIONAL = r102;
            f459542a = new Dimensional[]{r100, r101, r102};
        }

        public static Dimensional[] values() {
            return (Dimensional[]) f459542a.clone();
        }

        public static Dimensional valueOf(String r100) {
            return (Dimensional) a.a(Dimensional.class, r100);
        }

        private Dimensional(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum Layout extends Enum<Layout> {
        public static final Layout HORIZONTAL = null;
        public static final Layout UNKNOWN = null;
        public static final Layout VERTICAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Layout[] f459543a = null;

        static {
            Layout r100 = new Layout("UNKNOWN", 0);
            UNKNOWN = r100;
            Layout r101 = new Layout("HORIZONTAL", 1);
            HORIZONTAL = r101;
            Layout r102 = new Layout("VERTICAL", 2);
            VERTICAL = r102;
            f459543a = new Layout[]{r100, r101, r102};
        }

        public static Layout[] values() {
            return (Layout[]) f459543a.clone();
        }

        public static Layout valueOf(String r100) {
            return (Layout) a.a(Layout.class, r100);
        }

        private Layout(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ProjectionModel extends Enum<ProjectionModel> {
        public static final ProjectionModel CMP = null;
        public static final ProjectionModel EAC = null;
        public static final ProjectionModel ERP = null;
        public static final ProjectionModel MESH = null;
        public static final ProjectionModel UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ProjectionModel[] f459544a = null;

        static {
            ProjectionModel r100 = new ProjectionModel("UNKNOWN", 0);
            UNKNOWN = r100;
            ProjectionModel r101 = new ProjectionModel("ERP", 1);
            ERP = r101;
            ProjectionModel r102 = new ProjectionModel("EAC", 2);
            EAC = r102;
            ProjectionModel r103 = new ProjectionModel("CMP", 3);
            CMP = r103;
            ProjectionModel r104 = new ProjectionModel("MESH", 4);
            MESH = r104;
            f459544a = new ProjectionModel[]{r100, r101, r102, r103, r104};
        }

        public static ProjectionModel[] values() {
            return (ProjectionModel[]) f459544a.clone();
        }

        public static ProjectionModel valueOf(String r100) {
            return (ProjectionModel) a.a(ProjectionModel.class, r100);
        }

        private ProjectionModel(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final enum ViewingAngle extends Enum<ViewingAngle> {
        public static final ViewingAngle UNKNOWN = null;
        public static final ViewingAngle VIEWING_ANGLE_180 = null;
        public static final ViewingAngle VIEWING_ANGLE_360 = null;
        public static final ViewingAngle VIEWING_ANGLE_90 = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ViewingAngle[] f459545a = null;

        static {
            ViewingAngle r100 = new ViewingAngle("UNKNOWN", 0);
            UNKNOWN = r100;
            ViewingAngle r101 = new ViewingAngle("VIEWING_ANGLE_360", 1);
            VIEWING_ANGLE_360 = r101;
            ViewingAngle r102 = new ViewingAngle("VIEWING_ANGLE_180", 2);
            VIEWING_ANGLE_180 = r102;
            ViewingAngle r103 = new ViewingAngle("VIEWING_ANGLE_90", 3);
            VIEWING_ANGLE_90 = r103;
            f459545a = new ViewingAngle[]{r100, r101, r102, r103};
        }

        public static ViewingAngle[] values() {
            return (ViewingAngle[]) f459545a.clone();
        }

        public static ViewingAngle valueOf(String r100) {
            return (ViewingAngle) a.a(ViewingAngle.class, r100);
        }

        private ViewingAngle(String r100, int r101) {
            super(r100, r101);
        }
    }

    public void reset() {
        this.f459516a = -1;
        this.f459525j = -1;
        this.f459517b = 0;
        this.f459518c = 1;
        this.f459519d = 1;
        this.f459526k = -1;
        this.f459521f = 0;
        this.f459522g = 3;
        this.f459523h = 1;
        this.f459527l = 1;
        this.f459528m = 1;
        this.f459529n = 1.0f;
        this.f459524i = 0;
        this.f459530o = 1;
        this.f459531p = 1;
        this.f459533r = 0.015625f;
        this.f459534s = 1.006289f;
        this.f459532q = 0;
        this.f459535t = 4.0f;
        this.f459536u = 0.2f;
        this.f459537v = -1.0f;
        this.f459538w = 1.1f;
        this.f459539x = 100.0f;
        this.f459540y = 0.7f;
    }

    public int getBackgroundTexSize() {
        int r100 = this.f459526k;
        if (r100 == 0) goto L10;
        if (r100 < 180) goto L10;
        if (r100 <= 360) goto L9;
        return 360;
    L9:
        return r100;
    L10:
        return 180;
    }

    public DOF getDOF() {
        int r100 = this.f459520e;
        if (r100 == 0) goto L11;
        if (r100 == 1) goto L9;
        return DOF.UNKNOWN;
    L9:
        return DOF.SIX_DOF;
    L11:
        return DOF.THREE_DOF;
    }

    public int getDesireViewSize() {
        if (this.f459519d == 0) goto L6;
        return 360;
    L6:
        return 180;
    }

    public Dimensional getDimensional() {
        int r100 = this.f459517b;
        if (r100 == 0) goto L13;
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L11;
        return Dimensional.UNKNOWN;
    L11:
        return Dimensional.THREE_DIMENSIONAL;
    L13:
        return Dimensional.TWO_DIMENSIONAL;
    }

    public Layout getLayout() {
        int r100 = this.f459517b;
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return Layout.UNKNOWN;
    L9:
        return Layout.VERTICAL;
    L11:
        return Layout.HORIZONTAL;
    }

    public int getPanoramaMode() {
        return this.f459521f + 1;
    }

    public ProjectionModel getProjectionModel() {
        int r100 = this.f459524i;
        if (r100 == 0) goto L19;
        if (r100 == 1) goto L17;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L13;
        return ProjectionModel.UNKNOWN;
    L13:
        return ProjectionModel.MESH;
    L15:
        return ProjectionModel.CMP;
    L17:
        return ProjectionModel.EAC;
    L19:
        return ProjectionModel.ERP;
    }

    public int getSourceViewSize() {
        int r100 = this.f459518c;
        if (r100 != 0) goto L5;
        return 180;
    L5:
        if (r100 == 2) goto L8;
        return 360;
    L8:
        return 90;
    }

    public int getTextureRenderVRMode() {
        int r100 = this.f459524i;
        if (r100 == 2) goto L5;
        if (r100 == 1) goto L11;
    L14:
        return 1;
    L11:
        if (getViewingAngle() != ViewingAngle.VIEWING_ANGLE_360) goto L13;
        return 2;
    L13:
        getViewingAngle();
        ViewingAngle r101 = ViewingAngle.UNKNOWN;
        goto L14
    L5:
        if (getViewingAngle() != ViewingAngle.VIEWING_ANGLE_90) goto L7;
        return 1;
    L7:
        return 5;
    }

    public int getVideoStyle() {
        int r100 = this.f459517b;
        if (r100 != 0) goto L5;
        return 2;
    L5:
        if (r100 == 1) goto L10;
        if (r100 == 2) goto L8;
        return 1;
    L8:
        return 3;
    L10:
        return 4;
    }

    public int getVideoVRMode() {
        int r100 = this.f459524i;
        if (r100 == 1) goto L8;
        if (r100 == 2) goto L6;
        return 1;
    L6:
        return 5;
    L8:
        return 2;
    }

    public ViewingAngle getViewingAngle() {
        int r100 = this.f459518c;
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L13;
        if (r100 == 2) goto L11;
        return ViewingAngle.UNKNOWN;
    L11:
        return ViewingAngle.VIEWING_ANGLE_90;
    L13:
        return ViewingAngle.VIEWING_ANGLE_360;
    L15:
        return ViewingAngle.VIEWING_ANGLE_180;
    }

    public boolean isEnablePanoramaFilter() {
        if (this.f459516a == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public boolean isFpsSupportSharpen() {
        if (this.f459516a == 1) goto L5;
        return false;
    L5:
        if (this.f459537v == (-1.0f)) goto L9;
        return true;
    L9:
        return false;
    }

    public String toString() {
        return "VRParameter {Dimensional = " + getDimensional() + ", ViewingAngle = " + getViewingAngle() + ", Layout = " + getLayout() + ", DOF = " + getDOF() + ", ProjectionModel = " + getProjectionModel() + '}';
    }

    public VRParameter() {
        this.f459533r = 0.015625f;
        this.f459534s = 1.006289f;
        this.f459535t = 4.0f;
        this.f459536u = 0.2f;
        this.f459537v = -1.0f;
        this.f459538w = 1.1f;
        this.f459539x = 100.0f;
        this.f459540y = 0.7f;
        reset();
    }

    public float getExpandCoef() {
        if (getVideoVRMode() == 2) goto L7;
        return 1.0f;
    L7:
        return this.f459534s;
    }

    public float getCMPFaceInnerPadding() {
        return this.f459533r;
    }

    public float getPanoOutTextureScale() {
        return this.f459538w;
    }

    public float getTouchScaleMax() {
        return this.f459535t;
    }

    public float getTouchScaleMin() {
        return this.f459536u;
    }

    public float getVsyncFps() {
        return this.f459537v;
    }

    public void configWithSdkParams(JSONObject r210) {
        if (r210 != null) goto L73;
        return;
    L73:
    L70:
        e = move-exception;
        e.printStackTrace();
        return;
    L6:
        if (r210.has("VR") == false) goto L63;
        if (this.f459516a != (-1)) goto L10;
        this.f459516a = 1;     // Catch: JSONException -> L70
    L10:
        JSONObject r100 = new JSONObject(r210.optString("VR"));     // Catch: JSONException -> L70
        this.f459521f = r100.optInt("ScopicType");     // Catch: JSONException -> L70
        this.f459517b = r100.optInt("ContentType");     // Catch: JSONException -> L70
        this.f459518c = r100.optInt("FOV");     // Catch: JSONException -> L70
        if (r100.has("CMPFaceInnerPadding") == false) goto L14;
        this.f459533r = (float) JSONObjectProtectorUtils.getDouble(r100, "CMPFaceInnerPadding");     // Catch: JSONException -> L70
    L14:
        if (r100.has("ExpandCoef") == false) goto L17;
        this.f459534s = (float) JSONObjectProtectorUtils.getDouble(r100, "ExpandCoef");     // Catch: JSONException -> L70
    L17:
        if (this.f459525j != (-1)) goto L23;
        if (r100.has("BackgroundStickerEnable") == false) goto L21;
        this.f459525j = r100.optInt("BackgroundStickerEnable");     // Catch: JSONException -> L70
        goto L23
    L21:
        this.f459525j = 0;     // Catch: JSONException -> L70
    L23:
        if (r100.has("DesireFov") == false) goto L26;
        this.f459519d = r100.optInt("DesireFov");     // Catch: JSONException -> L70
    L30:
        if (this.f459526k != (-1)) goto L36;
        if (r100.has("BackgroundTexSize") == false) goto L34;
        this.f459526k = r100.optInt("BackgroundTexSize");     // Catch: JSONException -> L70
        goto L36
    L34:
        this.f459526k = 0;     // Catch: JSONException -> L70
    L36:
        if (r100.has("DOF") == false) goto L39;
        this.f459520e = r100.optInt("DOF");     // Catch: JSONException -> L70
    L39:
        if (r100.has("EnableTile") == false) goto L42;
        r100.optInt("EnableTile");     // Catch: JSONException -> L70
    L42:
        if (r100.has("ProjectionModel") == false) goto L45;
        this.f459524i = r100.optInt("ProjectionModel");     // Catch: JSONException -> L70
    L45:
        if (r100.has("SensorEnableSmoother") == false) goto L48;
        this.f459528m = r100.optInt("SensorEnableSmoother");     // Catch: JSONException -> L70
    L48:
        if (r100.has("SensorSmoothFactor") == false) goto L51;
        this.f459529n = (float) r100.optDouble("SensorSmoothFactor");     // Catch: JSONException -> L70
    L51:
        if (r100.has("PanoOutTextureScale") == false) goto L54;
        this.f459538w = (float) r100.optDouble("PanoOutTextureScale");     // Catch: JSONException -> L70
    L54:
        if (r100.has("VsyncFps") == false) goto L57;
        this.f459537v = (float) r100.optDouble("VsyncFps");     // Catch: JSONException -> L70
    L57:
        if (r100.has("PerspecView") == false) goto L60;
        this.f459539x = (float) r100.optDouble("PerspecView");     // Catch: JSONException -> L70
    L60:
        if (r100.has("ViewPortRatio") == false) goto L74;
        this.f459540y = (float) r100.optDouble("ViewPortRatio");     // Catch: JSONException -> L70
        return;
    L74:
        return;
    L26:
        if (this.f459525j != 1) goto L28;
        this.f459519d = 1;     // Catch: JSONException -> L70
        goto L30
    L28:
        this.f459519d = this.f459518c;     // Catch: JSONException -> L70
        goto L30
    L63:
        if (this.f459516a != (-1)) goto L65;
        int r101 = 0;
        this.f459516a = 0;     // Catch: JSONException -> L70
    L67:
        if (this.f459525j != (-1)) goto L76;
        this.f459525j = r101;     // Catch: JSONException -> L70
        return;
    L76:
        return;
    L65:
        r101 = 0;
        goto L67
    }

    public void setPanoOutTextureScale(float r100) {
        this.f459538w = r100;
    }

    public void setTouchScaleMax(float r100) {
        this.f459535t = Math.min(4.0f, Math.max(1.0f, r100));
    }

    public void setTouchScaleMin(float r100) {
        this.f459536u = Math.max(0.2f, Math.min(1.0f, r100));
    }

    public void configWithSdkParams(String r100) {
        if (r100 != null) goto L9;
        return;
    L9:
        configWithSdkParams(new JSONObject(r100));     // Catch: JSONException -> L6
        return;
    L6:
        e = move-exception;
        e.printStackTrace();
    }

    public int[] getPanoramaFilterOutTexSize(int r100, int r101) {
        if (getTextureRenderVRMode() == 2) goto L5;
    L7:
        double r102 = Math.ceil(((this.f459539x / 180.0f) * r101) * this.f459538w);
    L8:
        int r103 = (int) r102;
        int r104 = ((4 - (r103 % 4)) % 4) + r103;
        return new int[]{(int) Math.ceil((r104 * 1.0f) * this.f459540y), r104};
    L5:
        if (getSourceViewSize() != 180) goto L7;
        r102 = Math.ceil(((this.f459539x / 90.0f) * r101) * this.f459538w);
        goto L8
    }
}
