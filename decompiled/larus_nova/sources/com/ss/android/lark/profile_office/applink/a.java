package com.ss.android.lark.profile_office.applink;

import android.content.Context;
import com.ss.android.lark.applink.api.AppLinkHandlerPlugin;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import ova.d;
import pva.b;

/* JADX INFO: loaded from: classes37.dex */
@AppLinkHandlerPlugin
public final class a implements b {
    public a() {
    }

    @Override // pva.b
    public final Map<String, d> a(Context r100) {
        return MapsKt.hashMapOf(new Pair[]{TuplesKt.to("/invitation/page/add_contact/", new OfficeAddFriendAppLinkHandler())});
    }
}
