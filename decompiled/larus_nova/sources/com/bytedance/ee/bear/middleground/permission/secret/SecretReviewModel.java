package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes18.dex */
public class SecretReviewModel implements NonProguard {
    private ArrayList<SecretApprovalInstanceModel.Instance> instanceArrayList;
    private SecretLevel secretLevel;
    private int state;

    public SecretReviewModel() {
        this.state = 0;
    }

    public ArrayList<SecretApprovalInstanceModel.Instance> getInstanceArrayList() {
        return this.instanceArrayList;
    }

    public SecretLevel getSecretLevel() {
        return this.secretLevel;
    }

    public int getState() {
        return this.state;
    }

    public void setInstanceArrayList(ArrayList<SecretApprovalInstanceModel.Instance> r100) {
        this.instanceArrayList = r100;
    }

    public void setSecretLevel(SecretLevel r100) {
        this.secretLevel = r100;
    }

    public void setState(int r100) {
        this.state = r100;
    }
}
