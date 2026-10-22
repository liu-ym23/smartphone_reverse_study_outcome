package com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue;

import com.bytedance.ee.bear.bitable.card.model.stmodel.cell.PhoneInfo;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class PhoneModel implements NonProguard {
    public List<a> phoneItems;

    public static class a {
        public a() {
        }
    }

    public PhoneModel() {
    }

    public PhoneModel(PhoneInfo r100) {
        ArrayList r101 = new ArrayList();
        this.phoneItems = r101;
        r101.add(new a());
    }

    public PhoneModel(List<a> r100) {
        this.phoneItems = r100;
    }
}
