package com.bytedance.ee.bear.atfinder;

import com.bytedance.ee.bear.at.AtObject;
import com.bytedance.ee.util.io.NonProguard;
import java.io.Serializable;
import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public class AtFinderResult implements Serializable, NonProguard {
    public String keyword;
    public List<AtObject> list;

    public AtFinderResult() {
    }
}
