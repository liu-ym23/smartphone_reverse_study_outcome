package k96;

import com.bytedance.interaction.game.ext.goldenFinger.predefine.security.GoldenFingerFileValidate;

/* JADX INFO: loaded from: classes19.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f502160a = null;

    static {
        int[] r100 = new int[GoldenFingerFileValidate.TypeEnum.values().length];
        f502160a = r100;
        r100[GoldenFingerFileValidate.TypeEnum.MD5.ordinal()] = 1;
        r100[GoldenFingerFileValidate.TypeEnum.SHA256.ordinal()] = 2;
        r100[GoldenFingerFileValidate.TypeEnum.SIZE_SHA256.ordinal()] = 3;
    }
}
