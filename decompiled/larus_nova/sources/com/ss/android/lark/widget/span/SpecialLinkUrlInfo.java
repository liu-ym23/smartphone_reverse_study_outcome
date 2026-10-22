package com.ss.android.lark.widget.span;

/* JADX INFO: loaded from: classes38.dex */
public class SpecialLinkUrlInfo extends UrlInfo {
    public LinkType linkType;

    public static final enum LinkType extends Enum<LinkType> {
        public static final LinkType CustomLink = null;
        public static final LinkType None = null;
        public static final LinkType PossibleLink = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LinkType[] f448621a = null;

        static {
            LinkType r100 = new LinkType("None", 0);
            None = r100;
            LinkType r101 = new LinkType("PossibleLink", 1);
            PossibleLink = r101;
            LinkType r102 = new LinkType("CustomLink", 2);
            CustomLink = r102;
            f448621a = new LinkType[]{r100, r101, r102};
        }

        public static LinkType[] values() {
            return (LinkType[]) f448621a.clone();
        }

        public static LinkType valueOf(String r100) {
            return (LinkType) r27.a.a(LinkType.class, r100);
        }

        public LinkType(String r100, int r101) {
            super(r100, r101);
        }
    }

    public SpecialLinkUrlInfo() {
    }
}
