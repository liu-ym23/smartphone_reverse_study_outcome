package com.bytedance.ee.bear.drive.biz.comment.data;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.bytedance.ee.bear.contract.NetService;
import com.bytedance.ee.bear.contract.Result;
import com.bytedance.ee.bear.scaleimageview.areacomment.AreaCoordinate;
import java.io.Serializable;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AreaCommentFetcher {
    public final NetService.d<Result<ArrayList<AreaComment>>> a;
    public final NetService.d<Result> b;

    public static class AddParam implements Serializable {

        @JSONField(name = "comment_id")
        private String commentId;
        private Extra extra;

        @JSONField(name = "file_token")
        private String fileToken;
        private String version;

        public static class Extra implements Serializable {

            @JSONField(name = "drive_area_coordinate")
            private AreaCoordinate areaCoordinate;

            private Extra() {
            }

            public AreaCoordinate getAreaCoordinate() {
                return this.areaCoordinate;
            }

            public /* synthetic */ Extra(a r1) {
                this();
            }

            public void setAreaCoordinate(AreaCoordinate r1) {
                this.areaCoordinate = r1;
            }
        }

        private AddParam() {
        }

        public String getCommentId() {
            return this.commentId;
        }

        public Extra getExtra() {
            return this.extra;
        }

        public String getFileToken() {
            return this.fileToken;
        }

        public String getVersion() {
            return this.version;
        }

        public /* synthetic */ AddParam(a r1) {
            this();
        }

        public void setCommentId(String r1) {
            this.commentId = r1;
        }

        public void setExtra(Extra r1) {
            this.extra = r1;
        }

        public void setFileToken(String r1) {
            this.fileToken = r1;
        }

        public void setVersion(String r1) {
            this.version = r1;
        }
    }

    public static class AreaComment implements Serializable {

        @JSONField(name = "drive_area_coordinate")
        private AreaCoordinate areaCoordinate;

        @JSONField(name = "comment_id")
        private String commentId;

        public AreaComment() {
        }

        public AreaCoordinate getAreaCoordinate() {
            return this.areaCoordinate;
        }

        public String getCommentId() {
            return this.commentId;
        }

        public void setAreaCoordinate(AreaCoordinate r1) {
            this.areaCoordinate = r1;
        }

        public void setCommentId(String r1) {
            this.commentId = r1;
        }
    }

    public static /* synthetic */ class a {
    }

    public static class b implements NetService.c<Result<ArrayList<AreaComment>>> {

        public class a extends TypeReference<Result<ArrayList<AreaComment>>> {
            public a() {
            }
        }

        public b() {
        }

        @Override // com.bytedance.ee.bear.contract.NetService.c
        public final Result<ArrayList<AreaComment>> parse(String r3) throws NetService.ParseException {
            tt5.a.b("AreaCommentFetcher", "get comment " + r3);
            return (Result) JSON.parseObject(r3, new a(), new Feature[0]);
        }
    }

    public AreaCommentFetcher(NetService r2) {
        this.a = r2.Vc(new b());
        this.b = r2.Rb(Result.class);
    }
}
