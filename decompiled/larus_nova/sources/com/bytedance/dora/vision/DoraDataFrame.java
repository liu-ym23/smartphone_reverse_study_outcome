package com.bytedance.dora.vision;

/* JADX INFO: loaded from: classes15.dex */
public class DoraDataFrame {
    public byte[] assData;
    public int assId;
    public int count;
    public byte[] data;
    public boolean frameLoss;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    public int f204666id;
    public int scene;
    public int seq;
    public int stage;
    public int type;

    public String toString() {
        StringBuilder r100 = new StringBuilder("DoraDataFrame{stage=");
        r100.append(this.stage);
        r100.append(", scene=");
        r100.append(this.scene);
        r100.append(", id=");
        r100.append(this.f204666id);
        r100.append(", type=");
        r100.append(this.type);
        r100.append(", seq=");
        r100.append(this.seq);
        r100.append(", count=");
        r100.append(this.count);
        r100.append(", frameLoss=");
        r100.append(this.frameLoss);
        r100.append(", dataLength=");
        byte[] r101 = this.data;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        r100.append(r102);
        r100.append(", data=");
        byte[] r103 = this.data;
        String r104 = "null";
        if (r103 != null) goto L9;
        String r105 = "null";
    L10:
        r100.append(r105);
        r100.append(", assId=");
        r100.append(this.assId);
        r100.append(", assData=");
        byte[] r106 = this.assData;
        if (r106 == null) goto L14;
        r104 = new String(r106);
    L14:
        r100.append(r104);
        r100.append(", frameLoss=");
        r100.append(this.frameLoss);
        r100.append('}');
        return r100.toString();
    L9:
        r105 = new String(r103);
        goto L10
    L5:
        r102 = r101.length;
        goto L6
    }

    public DoraDataFrame(int r100, int r101, int r102, int r103, int r104, int r105, byte[] r106, int r107, byte[] r108, boolean r110) {
        this.stage = r100;
        this.f204666id = r102;
        this.scene = r101;
        this.type = r103;
        this.seq = r104;
        this.count = r105;
        this.data = r106;
        this.assId = r107;
        this.assData = r108;
        this.frameLoss = r110;
    }
}
