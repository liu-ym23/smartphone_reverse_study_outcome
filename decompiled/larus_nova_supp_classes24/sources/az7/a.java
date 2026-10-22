package az7;

import com.larksuite.component.card.component.audio.service.CardAudioStateEntity;
import com.larksuite.component.card.component.audio.service.c;
import com.lynx.react.bridge.JavaOnlyMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class a implements c {
    public final zy7.c a;

    public a(zy7.c r2) {
        Intrinsics.checkNotNullParameter(r2, "eventService");
        this.a = r2;
    }

    @Override // com.larksuite.component.card.component.audio.service.c
    public final void a(String r6, CardAudioStateEntity r7) {
        Intrinsics.checkNotNullParameter(r6, "sessionID");
        Intrinsics.checkNotNullParameter(r7, "state");
        this.a.k(CollectionsKt.listOf(JavaOnlyMap.from(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("sessionID", r6), TuplesKt.to("audio", JavaOnlyMap.from(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("state", r7.getState().getValue()), TuplesKt.to("position", Integer.valueOf(r7.getPosition())), TuplesKt.to("duration", Integer.valueOf(r7.getDuration()))})))}))));
    }
}
