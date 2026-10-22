package com.ss.android.lark.picker.base.view.avatar;

import android.graphics.drawable.Drawable;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.xiaomi.mipush.sdk.MiPushClient;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\u000b\u001a\u00020\nJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\rJ\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/picker/base/view/avatar/ExternalTargetAvatarProviderStore;", "", "<init>", "()V", "EXTRA_KEY_PROVIDER_MARKER", "", "TAG", ShortVideoSegments.KEY_PROP_PROVIDER, "Lcom/ss/android/lark/picker/base/view/avatar/ExternalTargetAvatarProvider;", MiPushClient.COMMAND_REGISTER, "", "clear", "requiresProvider", "", "data", "Lcom/ss/android/lark/search/dto/info/SearchBaseInfo;", "hasProvider", "createDrawableOrNull", "Landroid/graphics/drawable/Drawable;", "picker-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExternalTargetAvatarProviderStore {
    public static final String EXTRA_KEY_PROVIDER_MARKER = "external_target_avatar_provider_marker";
    public static final ExternalTargetAvatarProviderStore INSTANCE = null;
    private static final String TAG = "ExternalTargetAvatarStore";
    private static volatile ExternalTargetAvatarProvider provider;

    static {
        INSTANCE = new ExternalTargetAvatarProviderStore();
    }

    private ExternalTargetAvatarProviderStore() {
    }

    public final void clear() {
        provider = null;
    }

    public final Drawable createDrawableOrNull() {
        ExternalTargetAvatarProvider r100 = provider;
        if (r100 != null) goto L13;
        Log.w(TAG, "resolve external target avatar failed: provider unavailable");
        return null;
    L13:
        Drawable r101 = r100.createDrawable();     // Catch: Throwable -> L10
        if (r101 != null) goto L15;
        Log.w(TAG, "resolve external target avatar failed: drawable unavailable");     // Catch: Throwable -> L10
    L15:
        return r101;
    L10:
        th = move-exception;
        Log.e(TAG, "resolve external target avatar failed", th);
        return null;
    }

    public final boolean hasProvider() {
        if (provider == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final void register(ExternalTargetAvatarProvider r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        provider = r100;
    }

    public final boolean requiresProvider(SearchBaseInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        Map<String, Object> r101 = r100.getExtraParams();
        if (r101 != null) goto L7;
        return false;
    L7:
        return Intrinsics.areEqual(r101.get(EXTRA_KEY_PROVIDER_MARKER), Boolean.TRUE);
    }
}
