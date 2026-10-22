package os1;

import com.bytedance.android.livesdkapi.distribution.EXTERNAL_CONFIG_TYPE;

/* JADX INFO: loaded from: classes8.dex */
public final /* synthetic */ class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f526493a = null;

    static {
        int[] r100 = new int[EXTERNAL_CONFIG_TYPE.values().length];
        f526493a = r100;
        r100[EXTERNAL_CONFIG_TYPE.Gesture.ordinal()] = 1;
        r100[EXTERNAL_CONFIG_TYPE.Component.ordinal()] = 2;
        r100[EXTERNAL_CONFIG_TYPE.OrientationChange.ordinal()] = 3;
        r100[EXTERNAL_CONFIG_TYPE.LongPressPanel.ordinal()] = 4;
        r100[EXTERNAL_CONFIG_TYPE.Service.ordinal()] = 5;
    }
}
