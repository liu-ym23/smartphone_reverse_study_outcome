package gr2;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.revenue.service.livecore.IRegion;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class o implements IRegion, xh6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ti6.f f482326a;

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final boolean C1() {
        return this.f482326a.f546171m;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final int M4() {
        return this.f482326a.f546169k;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final boolean d2() {
        return this.f482326a.f546170l;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final double getHeight() {
        return this.f482326a.f546165g;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final String getInteractId() {
        String r100 = this.f482326a.f546160b;
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final IRegion.Type getMediaType() {
        int r100 = this.f482326a.f546159a;
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return IRegion.Type.UNKNOWN;
    L11:
        return IRegion.Type.AUDIO;
    L9:
        return IRegion.Type.VIDEO;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final IRegion.Status getStatus() {
        int r100 = this.f482326a.f546167i;
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return IRegion.Status.UNKNOWN;
    L14:
        return IRegion.Status.GAMEFULL;
    L15:
        return IRegion.Status.BACKGROUND;
    L12:
        return IRegion.Status.FOREGROUND;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final double getWidth() {
        return this.f482326a.f546164f;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final double getX() {
        return this.f482326a.f546162d;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final double getY() {
        return this.f482326a.f546163e;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final void m2() {
        ti6.b r100 = this.f482326a.f546181w;
        r100.f546155a = AudioStats.AUDIO_AMPLITUDE_NONE;
        r100.f546156b = AudioStats.AUDIO_AMPLITUDE_NONE;
        r100.f546157c = 1.0d;
        r100.f546158d = 1.0d;
    }

    public final String toString() {
        StringBuilder r100 = new StringBuilder("MainRegion(real=");
        r100.append(this.f482326a);
        r100.append(", userId=");
        String r101 = this.f482326a.f546161c;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.append(r101);
        r100.append(", isTalking=");
        r100.append(this.f482326a.f546168j);
        r100.append(", volume=");
        r100.append(this.f482326a.f546166h);
        r100.append(", talkVolume=");
        r100.append(this.f482326a.f546169k);
        r100.append(", muteAudio=");
        r100.append(this.f482326a.f546171m);
        r100.append(", y=");
        r100.append(this.f482326a.f546163e);
        r100.append(", x=");
        r100.append(this.f482326a.f546162d);
        r100.append(", height=");
        r100.append(this.f482326a.f546165g);
        r100.append(", width=");
        r100.append(this.f482326a.f546164f);
        r100.append(", interactId='");
        r100.append(getInteractId());
        r100.append("', status=");
        r100.append(getStatus());
        r100.append(", mediaType=");
        r100.append(getMediaType());
        r100.append(")");
        return r100.toString();
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final boolean z4() {
        return this.f482326a.f546168j;
    }

    @Override // xh6.c
    public final Object getReal() {
        return this.f482326a;
    }

    public o(ti6.f r100) {
        Intrinsics.checkNotNullParameter(r100, "real");
        this.f482326a = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final void J1(IRegion.Status r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = n.f482324a[r100.ordinal()];
        if (r101 != 1) goto L5;
        this.f482326a.f546167i = 0;
        return;
    L5:
        if (r101 != 2) goto L7;
        this.f482326a.f546167i = 1;
        return;
    L7:
        if (r101 != 3) goto L15;
        this.f482326a.f546167i = 2;
        return;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final void S3(boolean r100) {
        this.f482326a.f546171m = r100;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final o i3(boolean r100) {
        this.f482326a.f546170l = r100;
        return this;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final void l1(IRegion.Type r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        int r101 = n.f482325b[r100.ordinal()];
        if (r101 == 1) goto L7;
        if (r101 != 2) goto L10;
        this.f482326a.f546159a = 1;
        return;
    L10:
        return;
    L7:
        this.f482326a.f546159a = 2;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final o w3(int r100) {
        this.f482326a.f546173o = r100;
        return this;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final o C4(double r100, double r101) {
        ti6.f r102 = this.f482326a;
        r102.f546162d = r100;
        r102.f546163e = r101;
        return this;
    }

    @Override // com.bytedance.android.livesdk.revenue.service.livecore.IRegion
    public final o D3(double r100, double r101) {
        ti6.f r102 = this.f482326a;
        r102.f546164f = r100;
        r102.f546165g = r101;
        return this;
    }
}
