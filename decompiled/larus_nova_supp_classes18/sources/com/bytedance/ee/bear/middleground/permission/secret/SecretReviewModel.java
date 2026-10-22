package com.bytedance.ee.bear.middleground.permission.secret;

import com.bytedance.ee.bear.secret.SecretApprovalInstanceModel;
import com.bytedance.ee.bear.secret.SecretLevel;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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

    public void setInstanceArrayList(ArrayList<SecretApprovalInstanceModel.Instance> r1) {
        this.instanceArrayList = r1;
    }

    public void setSecretLevel(SecretLevel r1) {
        this.secretLevel = r1;
    }

    public void setState(int r1) {
        this.state = r1;
    }
}
