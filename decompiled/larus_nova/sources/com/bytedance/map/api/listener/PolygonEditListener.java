package com.bytedance.map.api.listener;

import com.bytedance.map.api.model.IPolygon;

/* JADX INFO: loaded from: classes21.dex */
public interface PolygonEditListener {
    void onEdit(IPolygon r100);

    void onEditEnd(IPolygon r100);

    void onEditStart(IPolygon r100);
}
