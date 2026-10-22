package com.ss.android.ugc.aweme.search.vision;

import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/IDialogFragmentLifecycle;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IDialogFragmentLifecycle {
    void onCreate(DialogFragment r100);

    void onResume(DialogFragment r100, FrameLayout r101);

    void onStart(DialogFragment r100, FrameLayout r101);

    void onStop(DialogFragment r100, FrameLayout r101);
}
