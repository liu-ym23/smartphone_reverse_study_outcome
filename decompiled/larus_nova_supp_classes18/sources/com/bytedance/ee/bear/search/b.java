package com.bytedance.ee.bear.search;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.search.picker.filter.folder.SearchFolderFragment;
import com.bytedance.ee.bear.search.picker.filter.wiki.WikiSearchPickerFragment;
import rj5.i0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface b {
    void a(FragmentActivity r1, i0 r2, Fragment r3);

    SearchFolderFragment b(Context r1, SelectFolderConfig r2);

    WikiSearchPickerFragment c(Context r1, Bundle r2);

    String d(String r1);
}
