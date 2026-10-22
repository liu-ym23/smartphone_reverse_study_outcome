package com.ss.android.vesdk.filterparam;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.android.vesdk.VELogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class VEComposerFilterParam extends VEBaseFilterParam {
    public static final Parcelable.Creator<VEComposerFilterParam> CREATOR = null;
    private static final String TAG = "VEComposerFilterParam";
    private static final int VEComposerAppendWithTag = 16;
    private static final int VEComposerReloadWithTag = 4;
    private static final int VEComposerRemove = 32;
    private static final int VEComposerReplaceWithTag = 64;
    private static final int VEComposerSetMode = 2;
    private static final int VEComposerSetNodesWithTag = 1;
    private static final int VEComposerUpdateMulti = 8;
    private int action;
    public boolean autoDump;
    private int mode;
    private String[] nodePaths;
    private String[] oldNodePaths;
    private int orderType;
    private boolean saveInTheModel;
    private int status;
    private String[] tags;
    private String[] updateNodeKeys;
    private float[] updateNodeValues;

    public class a implements Parcelable.Creator<VEComposerFilterParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VEComposerFilterParam createFromParcel(Parcel r100) {
            return new VEComposerFilterParam(r100);
        }

        @Override // android.os.Parcelable.Creator
        public final VEComposerFilterParam[] newArray(int r100) {
            return new VEComposerFilterParam[r100];
        }
    }

    private void reset() {
        this.mode = 0;
        this.orderType = 0;
        this.status = 0;
        this.action = 0;
        this.oldNodePaths = null;
        this.nodePaths = null;
        this.tags = null;
        this.updateNodeKeys = null;
        this.updateNodeValues = null;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean isOverallComposer() {
        return true;
    }

    static {
        CREATOR = new a();
    }

    public boolean isValid() {
        int r100 = this.action;
        boolean r101 = false;
        if (r100 != 1) goto L5;
    L38:
        String[] r102 = this.nodePaths;
        if (r102 == null) goto L46;
        String[] r103 = this.tags;
        if (r103 == null) goto L46;
        if (r102.length != r103.length) goto L46;
    L45:
        r101 = true;
    L46:
        if (r101 == true) goto L48;
        VELogUtil.e(TAG, "isValid, action: " + this.action + ", param invalid");
    L48:
        return r101;
    L5:
        if (r100 == 4) goto L38;
        if (r100 != 8) goto L9;
        String[] r104 = this.nodePaths;
        if (r104 == null) goto L46;
        String[] r105 = this.updateNodeKeys;
        if (r105 == null) goto L46;
        float[] r106 = this.updateNodeValues;
        if (r106 == null) goto L46;
        if (r104.length != r105.length) goto L46;
        if (r105.length == r106.length) goto L45;
    L9:
        if (r100 == 16) goto L38;
        if (r100 == 32) goto L25;
        if (r100 != 64) goto L45;
        if (this.oldNodePaths == null) goto L46;
        String[] r107 = this.nodePaths;
        if (r107 == null) goto L46;
        String[] r108 = this.tags;
        if (r108 == null) goto L46;
        if (r107.length == r108.length) goto L45;
    L25:
        if (this.nodePaths != null) goto L45;
        goto L45
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam
    public String toString() {
        return "VEComposerFilterParam{mode=" + this.mode + ", orderType=" + this.orderType + ", status=" + this.status + ", action='" + this.action + "', oldNodePaths='" + this.oldNodePaths + "', nodePaths='" + this.nodePaths + "', tags='" + this.tags + "', updateNodekeys='" + this.updateNodeKeys + "', updateNodeValues='" + this.updateNodeValues + "'}";
    }

    public VEComposerFilterParam() {
        this.saveInTheModel = false;
        this.autoDump = false;
        this.filterName = "composer filter";
        this.filterType = 18;
        this.filterDurationType = 1;
        reset();
    }

    public VEComposerFilterParam(Parcel r100) {
        super(r100);
        this.saveInTheModel = false;
        this.autoDump = false;
        this.mode = r100.readInt();
        this.orderType = r100.readInt();
        this.action = r100.readInt();
        r100.readStringArray(this.oldNodePaths);
        r100.readStringArray(this.nodePaths);
        r100.readStringArray(this.tags);
        r100.readStringArray(this.updateNodeKeys);
        r100.readFloatArray(this.updateNodeValues);
    }

    public void removeComposerNodes(String[] r100) {
        reset();
        this.action = 32;
        this.nodePaths = r100;
    }

    public void appendComposerNodesWithTag(String[] r100, String[] r101) {
        reset();
        this.action = 16;
        this.nodePaths = r100;
        this.tags = r101;
    }

    public void reloadComposerNodesWithTag(String[] r100, String[] r101) {
        reset();
        this.action = 4;
        this.nodePaths = r100;
        this.tags = r101;
    }

    public void setComposerMode(int r100, int r101) {
        reset();
        this.action = 2;
        this.mode = r100;
        this.orderType = r101;
    }

    public void setComposerNodesWithTag(String[] r100, String[] r101) {
        reset();
        this.action = 1;
        this.nodePaths = r100;
        this.tags = r101;
    }

    @Override // com.ss.android.vesdk.filterparam.VEBaseFilterParam, android.os.Parcelable
    public void writeToParcel(Parcel r100, int r101) {
        super.writeToParcel(r100, r101);
        r100.writeInt(this.mode);
        r100.writeInt(this.orderType);
        r100.writeInt(this.action);
        r100.writeStringArray(this.oldNodePaths);
        r100.writeStringArray(this.nodePaths);
        r100.writeStringArray(this.tags);
        r100.writeStringArray(this.updateNodeKeys);
        r100.writeFloatArray(this.updateNodeValues);
    }

    public void replaceComposerNodesWithTag(String[] r100, String[] r101, String[] r102) {
        reset();
        this.action = 64;
        this.oldNodePaths = r100;
        this.nodePaths = r101;
        this.tags = r102;
    }

    public void updateMultiComposerNodes(String[] r100, String[] r101, float[] r102) {
        reset();
        this.action = 8;
        this.nodePaths = r100;
        this.updateNodeKeys = r101;
        this.updateNodeValues = r102;
    }
}
