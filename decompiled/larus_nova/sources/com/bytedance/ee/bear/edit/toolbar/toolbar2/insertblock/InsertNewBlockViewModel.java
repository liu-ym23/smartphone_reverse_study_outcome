package com.bytedance.ee.bear.edit.toolbar.toolbar2.insertblock;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.model.toolbar.insertblock.InsertNewBlock;

/* JADX INFO: loaded from: classes16.dex */
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

    public InsertNewBlock.ChildData getChildDataById(String r110) {
        if (this.insertNewBlockLiveData.getValue() != null) goto L5;
        return null;
    L5:
        InsertNewBlock.Children[] r100 = this.insertNewBlockLiveData.getValue().getChildren();
        int r101 = r100.length;
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L14;
        InsertNewBlock.ChildData[] r103 = r100[r102].getData();
        int r104 = r103.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L13;
        InsertNewBlock.ChildData r106 = r103[r105];
        if (TextUtils.equals(r106.getId(), r110) == true) goto L11;
        r105 = r105 + 1;
        goto L8
    L11:
        return r106;
    L13:
        r102 = r102 + 1;
        goto L6
    L14:
        return null;
    }

    public void setDelegate(a r100) {
        this.delegate = r100;
    }

    public void updateInsertNewBlock(InsertNewBlock r100) {
        if (r100 == null) goto L5;
        this.insertNewBlockLiveData.setValue(r100);
        return;
    }
}
