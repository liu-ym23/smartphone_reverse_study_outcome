package com.ss.android.ugc.effectmanager.common.cachemanager;

import com.lynx.serval.svg.SVGRenderEngine;
import java.io.InputStream;
import java.util.regex.Pattern;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0007H&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\tH&J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007H&¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/effectmanager/common/cachemanager/ICache;", "", "clear", "", "has", "", "key", "", "queryToStream", "Ljava/io/InputStream;", "queryToValue", "remove", "removePattern", "pattern", "Ljava/util/regex/Pattern;", "patternStr", SVGRenderEngine.SAVE, "", "inputStream", "value", "effectmanager_release"}, k = 1, mv = {1, 1, 16})
public interface ICache {
    void clear();

    boolean has(String r100);

    InputStream queryToStream(String r100);

    String queryToValue(String r100);

    boolean remove(String r100);

    void removePattern(String r100);

    void removePattern(Pattern r100);

    long save(String r100, InputStream r101);

    long save(String r100, String r101);
}
