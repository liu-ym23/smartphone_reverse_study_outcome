package ij4;

import android.util.Pair;
import androidx.camera.video.AudioStats;
import com.monitor.cloudmessage.consts.CloudControlInf;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f490061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final double f490062b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b<T>[] f490063c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f490064d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String[] f490065e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final List<Pair<String, Float>> f490066f;

    public a(String r100, String[] r101, b... r102) {
        this.f490066f = new ArrayList();
        this.f490061a = r100;
        this.f490062b = AudioStats.AUDIO_AMPLITUDE_NONE;
        this.f490064d = CloudControlInf.ABTEST;
        this.f490065e = r101;
        this.f490063c = r102;
        int r103 = r102.length;
        int r104 = 0;
    L3:
        if (r104 >= r103) goto L5;
        b r105 = r102[r104];
        List<Pair<String, Float>> r106 = this.f490066f;
        ArrayList r107 = (ArrayList) r106;
        r107.add(new Pair(r105.f490067a, Double.valueOf(0.5d)));
        r104 = r104 + 1;
        goto L3
    }
}
