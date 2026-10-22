package com.dtf.toyger.base;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.dtf.toyger.base.ToygerAttr;
import com.dtf.toyger.base.algorithm.TGFrame;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public abstract class ToygerBiometricInfo<Attr extends ToygerAttr> {

    @JSONField(name = SlcElement.KEY_ATTR)
    public Attr attr;

    @JSONField(name = "encryptFrame")
    public TGFrame encryptFrame;

    @JSONField(name = "extras")
    public Map<String, String> extras;

    @JSONField(name = "frame")
    public TGFrame frame;

    @JSONField(name = "jpegFrame")
    public TGFrame jpegFrame;

    public ToygerBiometricInfo() {
    }
}
