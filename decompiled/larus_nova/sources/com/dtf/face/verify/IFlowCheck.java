package com.dtf.face.verify;

import android.content.Context;
import java.util.Map;

/* JADX INFO: loaded from: classes22.dex */
public interface IFlowCheck {
    String getCurrentFlow();

    boolean gotoNextFlow(Context r100, String r101, String r102, Map<String, Object> r103);
}
