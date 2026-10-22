package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class InsertNewBlockViewModel extends ViewModel {
    private a delegate;
    private MutableLiveData<InsertNewBlock> insertNewBlockLiveData;

    public interface a {
    }

    public void clearInsertNewBlockData() {
        if (this.insertNewBlockLiveData.getValue() == null) goto L6;
        this.insertNewBlockLiveData.setValue(null);
        return;
    }

    public InsertNewBlockViewModel() {
        this.insertNewBlockLiveData = new MutableLiveData();
    }

    public a getDelegate() {
        return this.delegate;
    }

    public LiveData<InsertNewBlock> getInsertNewBlockLiveData() {
        return this.insertNewBlockLiveData;
    }

    public InsertNewBlock.ChildData getChildDataById(String r11) {
        if (this.insertNewBlockLiveData.getValue() != null) goto L5;
        return null;
    L5:
        InsertNewBlock.Children[] r0 = ((InsertNewBlock) this.insertNewBlockLiveData.getValue()).getChildren();
        int r2 = r0.length;
        int r4 = 0;
    L6:
        if (r4 >= r2) goto L14;
        InsertNewBlock.ChildData[] r5 = r0[r4].getData();
        int r6 = r5.length;
        int r7 = 0;
    L8:
        if (r7 >= r6) goto L13;
        InsertNewBlock.ChildData r8 = r5[r7];
        if (TextUtils.equals(r8.getId(), r11) == true) goto L11;
        r7 = r7 + 1;
        goto L8
    L11:
        return r8;
    L13:
        r4 = r4 + 1;
        goto L6
    L14:
        return null;
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }

    public void updateInsertNewBlock(InsertNewBlock r2) {
        if (r2 == null) goto L5;
        this.insertNewBlockLiveData.setValue(r2);
        return;
    }
}
