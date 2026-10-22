package com.bytedance.upc;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\tH&J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H&¨\u0006\u0010"}, d2 = {"Lcom/bytedance/upc/IPrivacy;", "", "", "key", "default", "getPrivacyStatus", "value", "", "setPrivacyStatus", "Lcom/bytedance/upc/d;", "listener", "", "addPrivacyStatusChangeListener", "removePrivacyStatusChangeListener", "syncService", "clearPrivacyStatus", "com.bytedance.upc"}, k = 1, mv = {1, 4, 0})
public interface IPrivacy {
    void addPrivacyStatusChangeListener(d r100);

    boolean clearPrivacyStatus(boolean r100);

    String getPrivacyStatus(String r100, String r101);

    void removePrivacyStatusChangeListener(d r100);

    boolean setPrivacyStatus(String r100, String r101);
}
