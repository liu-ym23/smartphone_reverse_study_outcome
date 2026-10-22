package h6b;

import com.ss.android.lark.storage.LarkKVStorage;
import com.ss.android.lark.url.card.UrlCardProperty;

/* JADX INFO: loaded from: classes35.dex */
public final class f {
    static {
    }

    public static com.ss.android.lark.storage.kv.repo.a a() {
        return LarkKVStorage.p(new com.ss.android.lark.storage.a("domain_chat_preview"), UrlCardProperty.URL_PREVIEW_BUSINESS_TYPE, true);
    }
}
