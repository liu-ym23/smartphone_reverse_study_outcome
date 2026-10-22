package oja;

import com.obric.common.oea.style.scene.alpha.alphaplayer.model.AlphaVideoViewType;
import com.obric.common.oea.style.scene.alpha.alphaplayer.player.PlayerState;

/* JADX INFO: loaded from: classes33.dex */
public final /* synthetic */ class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f523597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f523598b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int[] f523599c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int[] f523600d = null;

    static {
        int[] r100 = new int[AlphaVideoViewType.values().length];
        f523597a = r100;
        r100[AlphaVideoViewType.GL_SURFACE_VIEW.ordinal()] = 1;
        r100[AlphaVideoViewType.GL_TEXTURE_VIEW.ordinal()] = 2;
        int[] r101 = new int[PlayerState.values().length];
        f523598b = r101;
        r101[PlayerState.PREPARED.ordinal()] = 1;
        PlayerState r102 = PlayerState.PAUSED;
        r101[r102.ordinal()] = 2;
        r101[PlayerState.NOT_PREPARED.ordinal()] = 3;
        r101[PlayerState.STOPPED.ordinal()] = 4;
        int[] r103 = new int[PlayerState.values().length];
        f523599c = r103;
        PlayerState r104 = PlayerState.STARTED;
        r103[r104.ordinal()] = 1;
        int[] r105 = new int[PlayerState.values().length];
        f523600d = r105;
        r105[r104.ordinal()] = 1;
        r105[r102.ordinal()] = 2;
    }
}
