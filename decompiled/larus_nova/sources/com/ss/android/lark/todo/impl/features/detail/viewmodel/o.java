package com.ss.android.lark.todo.impl.features.detail.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes38.dex */
public interface o {
    LiveData<Integer> getFollowIconState();

    LiveData<Integer> getLeftIconState();

    LiveData<Boolean> getMoreIconShow();

    LiveData<ArrayList<Integer>> getMoreIconState();

    LiveData<Boolean> getShareIconShow();

    MutableLiveData<b0> getTaskNumber();
}
