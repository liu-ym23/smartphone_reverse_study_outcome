package com.bytedance.lark.pb.search.v2;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum SearchScene extends Enum<SearchScene> implements WireEnum {
    private static final /* synthetic */ SearchScene[] $VALUES = null;
    public static final ProtoAdapter<SearchScene> ADAPTER = null;
    public static final SearchScene DEFAULT_SEARCH_SCENE = null;
    public static final SearchScene FILTER = null;
    public static final SearchScene LOCAL_COMMON = null;
    public static final SearchScene NAVIGATION_SEARCH = null;
    public static final SearchScene NEW_TAB = null;
    public static final SearchScene PINYIN_USER = null;
    public static final SearchScene RECOMMEND = null;
    public static final SearchScene UD = null;
    private final int value;

    static {
        SearchScene r100 = new SearchScene("DEFAULT_SEARCH_SCENE", 0, 0);
        DEFAULT_SEARCH_SCENE = r100;
        SearchScene r101 = new SearchScene("NEW_TAB", 1, 1);
        NEW_TAB = r101;
        SearchScene r102 = new SearchScene("RECOMMEND", 2, 2);
        RECOMMEND = r102;
        SearchScene r103 = new SearchScene("LOCAL_COMMON", 3, 3);
        LOCAL_COMMON = r103;
        SearchScene r104 = new SearchScene("NAVIGATION_SEARCH", 4, 4);
        NAVIGATION_SEARCH = r104;
        SearchScene r105 = new SearchScene("PINYIN_USER", 5, 5);
        PINYIN_USER = r105;
        SearchScene r110 = new SearchScene("UD", 6, 6);
        UD = r110;
        SearchScene r111 = new SearchScene(LocalSubStickerItem.BEAUTY_TYPE_FILTER, 7, 7);
        FILTER = r111;
        $VALUES = new SearchScene[]{r100, r101, r102, r103, r104, r105, r110, r111};
        ADAPTER = ProtoAdapter.newEnumAdapter(SearchScene.class);
    }

    public static SearchScene[] values() {
        return (SearchScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static SearchScene fromValue(int r100) {
        switch(r100) {
            case 0: goto L20;
            case 1: goto L18;
            case 2: goto L16;
            case 3: goto L14;
            case 4: goto L12;
            case 5: goto L10;
            case 6: goto L8;
            case 7: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return FILTER;
    L8:
        return UD;
    L10:
        return PINYIN_USER;
    L12:
        return NAVIGATION_SEARCH;
    L14:
        return LOCAL_COMMON;
    L16:
        return RECOMMEND;
    L18:
        return NEW_TAB;
    L20:
        return DEFAULT_SEARCH_SCENE;
    }

    public static SearchScene valueOf(String r100) {
        return (SearchScene) a.a(SearchScene.class, r100);
    }

    private SearchScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
