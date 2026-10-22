package com.bytedance.ee.bear.document;

import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.domain.BearUrl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface d extends com.bytedance.ee.bear.browser.plugin.i {
    BearUrl getBearUrl();

    LiveData<String> getDocName();

    String getDocumentType();

    int getDocumentTypeValue();

    String getEditionId();

    String getEditionToken();

    BearUrl getOriginBearUrl();

    String getOriginUrl();

    String getOwnerUserId();

    String getToken();

    String getUrl();

    boolean isEditionDoc();

    boolean isOwner();

    boolean isSyncBlock();
}
