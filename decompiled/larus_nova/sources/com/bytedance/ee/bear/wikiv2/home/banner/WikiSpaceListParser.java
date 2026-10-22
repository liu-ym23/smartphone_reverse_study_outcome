package com.bytedance.ee.bear.wikiv2.home.banner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.contract.route.parcelable.WikiDocument;
import com.bytedance.ee.bear.list.DocumentListInfo;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.u;
import com.bytedance.ee.util.io.NonProguard;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiSpaceListParser extends u {

    public static class Data implements NonProguard {
        public int attr;
        public long browse_time;
        public String description;
        public HomePage home_page;
        public boolean is_star;
        public SpaceCover space_cover;
        public String space_icon;
        public String space_id;
        public String space_name;
        public int wiki_scope;

        public static class HomePage implements NonProguard {
            public String obj_token;
            public int obj_type;
            public String wiki_token;

            public HomePage() {
            }
        }

        public static class SpaceCover implements NonProguard {
            public String color_value;
            public boolean is_graph_dark;
            public String key;
            public String origin;
            public String thumbnail;

            public SpaceCover() {
            }
        }

        public Data() {
        }
    }

    public class a extends TypeReference<Result<ArrayList<Data>>> {
        public a() {
        }
    }

    public WikiSpaceListParser() {
    }

    @Override // com.bytedance.ee.bear.list.u
    public final DocumentListInfo a(String r100) {
        Result r101 = (Result) JSON.parseObject(r100, new a(), new Feature[0]);
        ArrayList<Document> r102 = new ArrayList();
        Iterator r103 = ((ArrayList) r101.getData()).iterator();
    L4:
        if (r103.hasNext() == false) goto L12;
        Data r104 = (Data) r103.next();
        WikiDocument r105 = new WikiDocument();
        r105.f227888m = r104.space_id;
        r105.f227868a = r104.space_name;
        r105.f227895q = r104.space_icon;
        r105.f227910z = r104.is_star;
        r105.f227887l = String.valueOf(r104.browse_time);
        r105.P2 = r104.description;
        r105.O2 = r104.attr;
        r105.U2 = r104.wiki_scope;
        Data.HomePage r106 = r104.home_page;
        if (r106 == null) goto L9;
        r105.Q2 = r106.wiki_token;
        r105.f227873d = r106.obj_token;
        r105.f227869b = r106.obj_type;
    L9:
        if (r104.space_cover == null) goto L11;
        WikiDocument.SpaceCover r107 = new WikiDocument.SpaceCover();
        Data.SpaceCover r108 = r104.space_cover;
        r107.f217151c = r108.key;
        r107.f217153e = r108.color_value;
        r107.f217152d = r108.is_graph_dark;
        r107.f217149a = r108.origin;
        r107.f217150b = r108.thumbnail;
        r105.R2 = r107;
    L11:
        r102.add(r105);
        goto L4
    L12:
        DocumentListInfo r109 = new DocumentListInfo();
        r109.setDocumentList(r102);
        tt5.a.h("WikiSpaceListParser", "wiki space list size: " + r102.size());
        return r109;
    }

    @Override // com.bytedance.ee.bear.list.u, com.bytedance.ee.bear.contract.NetService.c
    public final /* bridge */ /* synthetic */ Result parse(String r100) throws NetService.ParseException {
        return a(r100);
    }
}
