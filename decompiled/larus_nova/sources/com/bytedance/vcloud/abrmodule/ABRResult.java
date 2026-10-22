package com.bytedance.vcloud.abrmodule;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class ABRResult {
    private List<ABRResultElement> elements;

    public int size() {
        return this.elements.size();
    }

    public ABRResult() {
        this.elements = new ArrayList();
    }

    public void add(ABRResultElement r100) {
        this.elements.add(r100);
    }

    public ABRResultElement get(int r100) {
        return (ABRResultElement) ListProtector.get(this.elements, r100);
    }
}
