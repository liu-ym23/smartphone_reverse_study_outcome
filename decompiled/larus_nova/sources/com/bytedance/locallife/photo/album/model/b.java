package com.bytedance.locallife.photo.album.model;

import com.bytedance.locallife.model.album.AlbumPageInfo;
import com.bytedance.locallife.model.album.PhotoData;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes21.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, HashMap<String, AlbumPageInfo>> f261973a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, List<PhotoData>> f261974b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Boolean> f261975c = null;

    static {
        f261973a = new ConcurrentHashMap();
        f261974b = new ConcurrentHashMap();
        f261975c = new ConcurrentHashMap();
    }
}
