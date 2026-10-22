package com.bytedance.ee.bear.search;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.search.picker.filter.folder.SearchFolderFragment;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import rj5.i0;

/* JADX INFO: loaded from: classes18.dex */
public interface b {
    void a(FragmentActivity r100, i0 r101, Fragment r102);

    SearchFolderFragment b(Context r100, SelectFolderConfig r101);

    WikiSearchPickerFragment c(Context r100, Bundle r101);

    String d(String r100);
}
