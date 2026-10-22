package com.facebook.cache.common;

import android.net.Uri;

/* JADX INFO: loaded from: classes3.dex */
public interface CacheKey {
    boolean containsUri(Uri r100);

    boolean equals(Object r100);

    String getUriString();

    int hashCode();

    String toString();
}
