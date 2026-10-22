package com.obric.eventkit.eventstaskmanager;

import android.net.Uri;
import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import com.bytedance.mt.protector.impl.UriProtector;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/eventkit/eventstaskmanager/UriTypeAdapter;", "Lcom/google/gson/TypeAdapter;", "Landroid/net/Uri;", "()V", "read", "input", "Lcom/google/gson/stream/JsonReader;", "write", "", Argument.OUT, "Lcom/google/gson/stream/JsonWriter;", "value", "eventstaskkit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class UriTypeAdapter extends TypeAdapter<Uri> {
    public UriTypeAdapter() {
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.gson.TypeAdapter
    public Uri read(JsonReader r100) {
        Intrinsics.checkNotNullParameter(r100, "input");
        return UriProtector.parse(r100.nextString());
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ Uri read(JsonReader r100) {
        return read(r100);
    }

    /* JADX INFO: renamed from: write, reason: avoid collision after fix types in other method */
    public void write2(JsonWriter r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, Argument.OUT);
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        r100.value(r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.google.gson.TypeAdapter
    public /* bridge */ /* synthetic */ void write(JsonWriter r100, Uri r101) {
        write2(r100, r101);
    }
}
