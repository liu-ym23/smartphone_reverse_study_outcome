package com.ss.android.ugc.aweme.live.alphaplayer.render;

import com.ss.android.ugc.aweme.live.alphaplayer.model.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/live/alphaplayer/render/AlphaVideoProgram;", "", "alpha_player_release"}, k = 1, mv = {1, 4, 0})
public final class AlphaVideoProgram {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteBuffer f451201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ByteBuffer f451202b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ByteBuffer f451203c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f451204d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f451205e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f451206f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f451207g;

    public static void a(Rect r110, ByteBuffer r111, boolean r112) {
        r111.clear();
        int r100 = 0;
        if (r112 == false) goto L5;
        float r101 = r110.f451170b;
        float r102 = r110.f451171c;
        float r113 = r110.f451173e + r102;
        float r103 = r101 + r110.f451172d;
        float[] r114 = {r101, r113, r101, r102, r103, r113, r103, r102};
    L6:
        int r115 = r114.length;
    L7:
        if (r100 >= r115) goto L9;
        r111.putFloat(r114[r100]);
        r100 = r100 + 1;
        goto L7
    L9:
        r111.flip();
        return;
    L5:
        float r104 = r110.f451170b;
        float r105 = r110.f451171c;
        float r106 = r110.f451173e + r105;
        float r107 = r104 + r110.f451172d;
        r114 = new float[]{r104, r105, r104, r106, r107, r105, r107, r106};
        goto L6
    }

    public AlphaVideoProgram(int r100, int r101, int r102, int r103) {
        this.f451204d = r100;
        this.f451205e = r101;
        this.f451206f = r102;
        this.f451207g = r103;
        this.f451201a = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        this.f451202b = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
        this.f451203c = ByteBuffer.allocateDirect(32).order(ByteOrder.nativeOrder());
    }
}
