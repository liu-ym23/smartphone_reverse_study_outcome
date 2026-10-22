package com.lynx.devtool.recorder;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.nova.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes32.dex */
public class LynxRecorderReplayStateView extends LinearLayout {
    public static final int DOWNLOAD_JSON_FILE = 0;
    public static final int ERROR_DOWNLOAD_FAILED = 5;
    public static final int ERROR_MISS_LYNXRECORDER_HEADER = 6;
    public static final int HANDLE_ACTION_LIST = 2;
    public static final int INVALID_JSON_FILE = 3;
    public static final int PARSING_JSON_FILE = 1;
    public static final int RECORD_ERROR_MISS_TEMPLATEJS = 4;
    private static final ArrayList<String> mState = null;
    private ProgressBar mProgress;
    private TextView mText;

    static {
        ArrayList<String> r100 = new ArrayList();
        mState = r100;
        ListProtector.add(r100, 0, "Download json file");
        ListProtector.add(r100, 1, "Parsing json file");
        ListProtector.add(r100, 2, "Handle action list");
        ListProtector.add(r100, 3, "Invalid Json File");
        ListProtector.add(r100, 4, "Record Error: Miss template.js");
        ListProtector.add(r100, 5, "LynxRecorder artifact download failed");
        ListProtector.add(r100, 6, "Miss LynxRecorder header : file://lynxrecorder?url={{{url}}}");
    }

    public void updateScreenMetrics() {
        WindowManager r100 = (WindowManager) getContext().getSystemService(LiveEndPageData.TAG_WINDOW);
        Point r101 = new Point();
        r100.getDefaultDisplay().getSize(r101);
        ViewGroup.LayoutParams r102 = getLayoutParams();
        if (r102 != null) goto L5;
        r102 = new LinearLayout.LayoutParams(r101.x, r101.y);
    L6:
        setLayoutParams(r102);
        return;
    L5:
        r102.width = r101.x;
        r102.height = r101.y;
        goto L6
    }

    public LynxRecorderReplayStateView(Context r100) {
        super(r100);
        setId(R.id.recorder_state_view);
        init(r100);
    }

    private int getProgress(int r100) {
        return ((r100 + 1) * 100) / (mState.size() + 1);
    }

    private void init(Context r100) {
        LayoutInflater.from(r100).inflate(R.layout.recorder_replay_state, this);
        updateScreenMetrics();
        setGravity(17);
        this.mText = (TextView) findViewById(R.id.textView2);
        this.mProgress = (ProgressBar) findViewById(R.id.progressBar2);
    }

    public void setReplayState(int r100) {
        if (this.mText != null) goto L5;
        return;
    L5:
        if (this.mProgress == null) goto L13;
        if (r100 < 0) goto L10;
        ArrayList<String> r101 = mState;
        if (r100 >= r101.size()) goto L10;
        this.mText.setText((CharSequence) ListProtector.get(r101, r100));
        this.mProgress.setProgress(getProgress(r100));
        return;
    L10:
        this.mText.setText("Unknown State");
        this.mProgress.setProgress(0);
        return;
    }
}
