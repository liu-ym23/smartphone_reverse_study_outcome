package com.obric.sva.sdk.xmlhelper;

import com.alipay.sdk.m.u.i;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class ContainerGroup {
    private HashMap<String, Container> mContainers;

    public String toString() {
        StringBuilder r100 = new StringBuilder("ContainerGroup = {\n");
        Iterator<Map.Entry<String, Container>> r101 = this.mContainers.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100.append(r101.next().getValue().toString());
        r100.append("\n");
        goto L4
    L6:
        r100.append(i.f25855d);
        return r100.toString();
    }

    public ContainerGroup() {
        this.mContainers = new HashMap();
    }

    public void addContainer(Container r100) {
        this.mContainers.put(r100.getName(), r100);
    }

    public Container getContainer(String r100) {
        return this.mContainers.get(r100);
    }
}
