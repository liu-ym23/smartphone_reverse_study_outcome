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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
    public final DocumentListInfo a(String r6) {
        Result r7 = (Result) JSON.parseObject(r6, new a(), new Feature[0]);
        ArrayList<Document> r0 = new ArrayList();
        Iterator r8 = ((ArrayList) r7.getData()).iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        Data r1 = (Data) r8.next();
        WikiDocument r2 = new WikiDocument();
        r2.m = r1.space_id;
        r2.a = r1.space_name;
        r2.q = r1.space_icon;
        r2.z = r1.is_star;
        r2.l = String.valueOf(r1.browse_time);
        r2.P2 = r1.description;
        r2.O2 = r1.attr;
        r2.U2 = r1.wiki_scope;
        Data.HomePage r3 = r1.home_page;
        if (r3 == null) goto L9;
        r2.Q2 = r3.wiki_token;
        r2.d = r3.obj_token;
        r2.b = r3.obj_type;
    L9:
        if (r1.space_cover == null) goto L11;
        WikiDocument.SpaceCover r4 = new WikiDocument.SpaceCover();
        Data.SpaceCover r5 = r1.space_cover;
        r4.c = r5.key;
        r4.e = r5.color_value;
        r4.d = r5.is_graph_dark;
        r4.a = r5.origin;
        r4.b = r5.thumbnail;
        r2.R2 = r4;
    L11:
        r0.add(r2);
        goto L4
    L12:
        DocumentListInfo r9 = new DocumentListInfo();
        r9.setDocumentList(r0);
        tt5.a.h("WikiSpaceListParser", "wiki space list size: " + r0.size());
        return r9;
    }

    @Override // com.bytedance.ee.bear.list.u
    public final /* bridge */ /* synthetic */ Result parse(String r1) throws NetService.ParseException {
        return a(r1);
    }
}
