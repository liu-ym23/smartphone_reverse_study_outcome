package com.larus.larkfeed.impl.lark.holder.content.longpress;

import com.ss.android.lark.biz.im.extension.message_action.MessageActionType;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f355382a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355383a = null;

        static {
            int[] r100 = new int[DouBaoMenuScene.values().length];
            r100[DouBaoMenuScene.TEXT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[DouBaoMenuScene.PURE_VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[DouBaoMenuScene.CREATION_IMAGE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[DouBaoMenuScene.CREATION_VIDEO.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[DouBaoMenuScene.WIDGET_CARD.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[DouBaoMenuScene.MUSIC_CARD.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[DouBaoMenuScene.GENERIC_CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            f355383a = r100;
        }
    }

    static {
    }

    public static List b() {
        return CollectionsKt.listOf(new yya.d[]{new yya.d(MessageActionType.FLOW_FEEDBACK), new yya.d(MessageActionType.RECALL), new yya.d(MessageActionType.DELETE)});
    }

    public static yya.k a(List r100) {
        MessageActionType r101 = MessageActionType.FLOW_MORE;
        return new yya.k("", CollectionsKt.listOf(r101), 0, MapsKt.mapOf(TuplesKt.to(r101, r100)));
    }

    public static yya.k c(MessageActionType... r100) {
        return new yya.k(ArraysKt.toList(r100), 0, 8);
    }
}
