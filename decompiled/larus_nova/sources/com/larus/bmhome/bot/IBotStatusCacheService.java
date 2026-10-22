package com.larus.bmhome.bot;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0017\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\tJ\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0007H&J\u0017\u0010\f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\tJ\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lcom/larus/bmhome/bot/IBotStatusCacheService;", "", "setStatus", "", "botId", "", "status", "", "getStatus", "(Ljava/lang/String;)Ljava/lang/Boolean;", "setChatOnly", "chatOnly", "getChatOnly", "clear", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IBotStatusCacheService {
    void a(String r100, boolean r101);

    Boolean b(String r100);

    Boolean c(String r100);

    void clear();

    void d(String r100, boolean r101);
}
