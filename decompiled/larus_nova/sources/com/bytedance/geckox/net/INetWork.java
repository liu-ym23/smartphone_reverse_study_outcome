package com.bytedance.geckox.net;

import android.util.Pair;
import java.util.List;
import py5.b;
import wy5.e;

/* JADX INFO: loaded from: classes3.dex */
public interface INetWork {
    e doGet(String r100) throws Exception;

    e doPost(String r100, String r101) throws Exception;

    e doPost(String r100, List<Pair<String, String>> r101) throws Exception;

    void downloadFile(String r100, long r101, b r102) throws Exception;
}
