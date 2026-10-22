package com.ss.ttvideoengine.configcenter;

import com.ss.ttm.player.MediaPlayer;
import com.ss.ttvideoengine.utils.TTVideoEngineInternalLog;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class PlayerConfigExecutor {
    public static final PlayerConfigExecutor EMPTY = null;
    private static final String TAG = "PlayerConfigExecutor";
    private boolean mEnableOptionArray;
    private MediaPlayer mMediaPlayer;

    public PlayerConfigExecutor() {
    }

    static {
        EMPTY = new PlayerConfigExecutor();
    }

    public PlayerConfigExecutor(boolean r100) {
        this.mEnableOptionArray = r100;
    }

    public void execute(ConfigItem r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.moduleType != 1) goto L9;
        execute(r100.valueType, r100.configKey, r100.itemValue);
        return;
    }

    public void setMediaPlayer(MediaPlayer r100) {
        this.mMediaPlayer = r100;
    }

    private void executeUsingArray(Map<Integer, ConfigItem> r100, int r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isEmpty() == true) goto L64;
        int[] r101 = new int[r100.size()];
        int[] r102 = new int[r100.size()];
        Iterator<ConfigItem> r103 = r100.values().iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L34;
        ConfigItem r105 = r103.next();
        if (r105.moduleType != 1) goto L8;
        if (((PlayerConfigItem) r105).batchExecuteStage != r110) goto L8;
        int r106 = r105.valueType;
        if (r106 != 1) goto L18;
        r101[r104] = r105.configKey;
        r102[r104] = ((Integer) r105.itemValue).intValue();
        r104 = r104 + 1;
        goto L8
    L18:
        if (r106 != 2) goto L20;
        MediaPlayer r107 = this.mMediaPlayer;
        if (r107 == null) goto L8;
        r107.setLongOption(r105.configKey, ((Long) r105.itemValue).longValue());
        goto L8
    L20:
        if (r106 != 3) goto L22;
        MediaPlayer r108 = this.mMediaPlayer;
        if (r108 == null) goto L8;
        r108.setFloatOption(r105.configKey, ((Float) r105.itemValue).floatValue());
        goto L8
    L22:
        if (r106 != 4) goto L23;
        MediaPlayer r109 = this.mMediaPlayer;
        if (r109 == null) goto L8;
        r109.setStringOption(r105.configKey, (String) r105.itemValue);
        goto L8
    L23:
        TTVideoEngineInternalLog.e(TAG, "unknown value type");
        goto L8
    L34:
        if (r104 <= 0) goto L63;
        this.mMediaPlayer.setIntOptionArray(Arrays.copyOf(r101, r104), Arrays.copyOf(r102, r104));
        return;
    L63:
        return;
    }

    public void execute(Map<Integer, ConfigItem> r100, int r101) {
        if (this.mEnableOptionArray == false) goto L6;
        executeUsingArray(r100, r101);
        return;
    L6:
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.isEmpty() == true) goto L28;
        Iterator<ConfigItem> r102 = r100.values().iterator();
    L12:
        if (r102.hasNext() == false) goto L29;
        ConfigItem r103 = r102.next();
        if (r103.moduleType != 1) goto L12;
        if (((PlayerConfigItem) r103).batchExecuteStage != r101) goto L12;
        execute(r103.valueType, r103.configKey, r103.itemValue);
        goto L12
    L29:
        return;
    }

    public void execute(int r100, int r101, Object r102) {
        MediaPlayer r103 = this.mMediaPlayer;
        if (r103 != null) goto L6;
        return;
    L6:
        if (r100 != 1) goto L8;
        r103.setIntOption(r101, ((Integer) r102).intValue());
        return;
    L8:
        if (r100 != 2) goto L10;
        r103.setLongOption(r101, ((Long) r102).longValue());
        return;
    L10:
        if (r100 != 3) goto L12;
        r103.setFloatOption(r101, ((Float) r102).floatValue());
        return;
    L12:
        if (r100 == 4) goto L14;
        TTVideoEngineInternalLog.e(TAG, "unknown value type");
        return;
    L14:
        r103.setStringOption(r101, (String) r102);
    }
}
